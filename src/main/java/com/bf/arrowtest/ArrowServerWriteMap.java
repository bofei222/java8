package com.bf.arrowtest;

import org.apache.arrow.flight.*;
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

/**
 * @description:
 * @author: bofei
 * @date: 2024-09-03 17:51
 **/
public class ArrowServerWriteMap {
    public static void main(String[] args) {

        Location location = Location.forGrpcInsecure("10.162.4.45", 8815);
        try (BufferAllocator allocator = new RootAllocator()) {


            // Client
            try (FlightClient flightClient = FlightClient.builder(allocator, location).build()) {
                System.out.println("C1: Client (Location): Connected to " + location.getUri());


// 创建测试数据
                Map<String, Object> mapData = new HashMap<>();
                mapData.put("name", "Alice");
                mapData.put("age", 30);
                mapData.put("timestamp", System.currentTimeMillis());


                try {
                    // 动态生成 Schema
                    List<Field> fields = new ArrayList<>();
                    for (Map.Entry<String, Object> entry : mapData.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        Field field = null;

                        // 根据值的类型动态生成对应的字段类型
                        if (value instanceof String) {
                            field = new Field(key, FieldType.nullable(new ArrowType.Utf8()), null);
                        } else if (value instanceof Integer) {
                            field = new Field(key, FieldType.nullable(new ArrowType.Int(32, true)), null);
                        } else if (value instanceof Long) {
                            field = new Field(key, FieldType.nullable(new ArrowType.Int(64, true)), null);
                        }
                        // 可以根据需要添加更多类型支持 (如 Double, Boolean, etc.)

                        if (field != null) {
                            fields.add(field);
                        }
                    }

                    Schema schema = new Schema(fields);

                    // 创建 VectorSchemaRoot
                    try (VectorSchemaRoot vectorSchemaRoot = VectorSchemaRoot.create(schema, allocator)) {

                        // 为每个字段动态创建向量并填充数据
                        int rowCount = 1;  // 假设 Map 只对应一行数据


                        for (Map.Entry<String, Object> entry : mapData.entrySet()) {
                            String key = entry.getKey();
                            Object value = entry.getValue();

                            FieldVector vector = vectorSchemaRoot.getVector(key);

                            if (value instanceof String) {
                                VarCharVector varCharVector = (VarCharVector) vector;
                                varCharVector.allocateNew(rowCount);
                                varCharVector.set(0, ((String) value).getBytes());
                            } else if (value instanceof Integer) {
                                IntVector intVector = (IntVector) vector;
                                intVector.allocateNew(rowCount);
                                intVector.set(0, (Integer) value);
                            } else if (value instanceof Long) {
                                BigIntVector bigIntVector = (BigIntVector) vector;
                                bigIntVector.allocateNew(rowCount);
                                bigIntVector.set(0, (Long) value);
                            }
                            // 同样可以添加对其他类型的处理
                        }

                        // 必须在这里，先设置向量（列），再设置行。 如果在上面 就没有数据写入
                        vectorSchemaRoot.setRowCount(rowCount);
                        FlightClient.ClientStreamListener listener = flightClient.startPut(
                                FlightDescriptor.path("file_realtime_001_schema888"),
                                vectorSchemaRoot, new AsyncPutListener());

                        listener.putNext();
                        Thread.sleep(1000);

                    }
                } finally {
                    allocator.close();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}