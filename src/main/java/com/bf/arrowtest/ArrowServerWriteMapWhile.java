package com.bf.arrowtest;

import org.apache.arrow.flight.AsyncPutListener;
import org.apache.arrow.flight.FlightClient;
import org.apache.arrow.flight.FlightDescriptor;
import org.apache.arrow.flight.Location;
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.memory.RootAllocator;
import org.apache.arrow.vector.*;
import org.apache.arrow.vector.types.pojo.ArrowType;
import org.apache.arrow.vector.types.pojo.Field;
import org.apache.arrow.vector.types.pojo.FieldType;
import org.apache.arrow.vector.types.pojo.Schema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrowServerWriteMapWhile {
    public static void main(String[] args) {

        Location location = Location.forGrpcInsecure("10.19.8.243", 8815);
//        Location location = Location.forGrpcInsecure("10.162.4.45", 8815);
        try (BufferAllocator allocator = new RootAllocator()) {

            // Client
            try (FlightClient flightClient = FlightClient.builder(allocator, location).build()) {
                System.out.println("C1: Client (Location): Connected to " + location.getUri());

                // 动态生成的 Map 数据（字段名和类型是动态的）
                Map<String, Object> mapData = new HashMap<>();
                mapData.put("name", "User_0");  // 动态生成用户名称
                mapData.put("age", 20);        // 动态生成年龄
                mapData.put("timestamp", System.currentTimeMillis() / 1000);  // 当前时间戳

                // 根据 mapData 动态生成 Schema
                List<Field> fields = new ArrayList<>();
                for (Map.Entry<String, Object> entry : mapData.entrySet()) {
                    Field field = createFieldFromEntry(entry);
                    fields.add(field);
                }
                Schema schema = new Schema(fields);

                // 创建 VectorSchemaRoot
                try (VectorSchemaRoot vectorSchemaRoot = VectorSchemaRoot.create(schema, allocator)) {

                    // 创建 StreamListener 只做一次
                    FlightClient.ClientStreamListener listener = flightClient.startPut(
                            FlightDescriptor.path("file_realtime_001_schema888"),
                            vectorSchemaRoot, new AsyncPutListener());

                    // 设置行数为1，因为我们假设每次发送一行数据
                    int rowCount = 1;

                    // 分配向量内存并更新数据
                    for (int i = 0; i < 2; i++) {  // 假设我们只发送 2 次，循环次数可根据需求修改

                        // 每次生成新的 map 数据
                        mapData.put("name", "User_" + i);  // 动态生成用户名称
                        mapData.put("age", 20 + i);        // 动态生成年龄
                        mapData.put("timestamp", System.currentTimeMillis() / 1000);  // 当前时间戳

                        // 动态填充 Vector
                        updateVectorWithMapData(vectorSchemaRoot, mapData, rowCount);

                        // 设置行数
                        vectorSchemaRoot.setRowCount(rowCount);

                        // 发送数据到服务器
                        listener.putNext();
                        System.out.println("Put data for User_" + i);

                        // 等待1秒钟再发送下一批数据
//                        Thread.sleep(1000);
                    }

                    // 完成数据发送
//                    listener.completed();
                    System.out.println("Data sending completed.");

                } catch (Exception e) {
                    System.err.println("Error in data sending: " + e.getMessage());
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 根据 Map 中的键值对动态创建 Field
    private static Field createFieldFromEntry(Map.Entry<String, Object> entry) {
        String key = entry.getKey();
        Object value = entry.getValue();

        if (value instanceof Integer) {
            return new Field(key, FieldType.nullable(new ArrowType.Int(32, true)), null);
        } else if (value instanceof Long) {
            return new Field(key, FieldType.nullable(new ArrowType.Int(64, true)), null);
        } else if (value instanceof String) {
            return new Field(key, FieldType.nullable(new ArrowType.Utf8()), null);
        } else {
            throw new IllegalArgumentException("Unsupported data type: " + value.getClass());
        }
    }

    // 根据 Map 数据更新对应的向量
    private static void updateVectorWithMapData(VectorSchemaRoot vectorSchemaRoot, Map<String, Object> mapData, int rowCount) {
        for (Map.Entry<String, Object> entry : mapData.entrySet()) {
            String fieldName = entry.getKey();
            Object value = entry.getValue();
            FieldVector vector = vectorSchemaRoot.getVector(fieldName);

            if (vector instanceof IntVector) {
                ((IntVector) vector).allocateNew(rowCount);
                ((IntVector) vector).set(0, (Integer) value);
            } else if (vector instanceof BigIntVector) {
                ((BigIntVector) vector).allocateNew(rowCount);
                ((BigIntVector) vector).set(0, (Long) value);
            } else if (vector instanceof VarCharVector) {
                ((VarCharVector) vector).allocateNew(rowCount);
                ((VarCharVector) vector).set(0, value.toString().getBytes());
            }
        }
    }
}
