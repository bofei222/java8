package com.bf.arrowtest;

import org.apache.arrow.flight.AsyncPutListener;
import org.apache.arrow.flight.FlightClient;
import org.apache.arrow.flight.FlightDescriptor;
import org.apache.arrow.flight.Location;
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.memory.RootAllocator;
import org.apache.arrow.vector.BigIntVector;
import org.apache.arrow.vector.IntVector;
import org.apache.arrow.vector.VarCharVector;
import org.apache.arrow.vector.VectorSchemaRoot;
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
 * @date: 2024-10-10 11:45
 **/
public class ArrowServerWriteMapWhile {
    public static void main(String[] args) {

        Location location = Location.forGrpcInsecure("10.162.4.45", 8815);
        try (BufferAllocator allocator = new RootAllocator()) {

            // Client
            try (FlightClient flightClient = FlightClient.builder(allocator, location).build()) {
                System.out.println("C1: Client (Location): Connected to " + location.getUri());

                // 动态生成 Schema 的代码只需要做一次，因为我们假设字段结构不变
                List<Field> fields = new ArrayList<>();
                fields.add(new Field("name", FieldType.nullable(new ArrowType.Utf8()), null));
                fields.add(new Field("age", FieldType.nullable(new ArrowType.Int(32, true)), null));
                fields.add(new Field("timestamp", FieldType.nullable(new ArrowType.Int(64, true)), null));

                Schema schema = new Schema(fields);

                // 创建 VectorSchemaRoot
                try (VectorSchemaRoot vectorSchemaRoot = VectorSchemaRoot.create(schema, allocator)) {

                    // 创建 StreamListener 只做一次
                    FlightClient.ClientStreamListener listener = flightClient.startPut(
                            FlightDescriptor.path("file_realtime_001_schema888"),
                            vectorSchemaRoot, new AsyncPutListener());

                    // 设置行数为1，因为我们假设每次发送一行数据
                    int rowCount = 1;

                    // 分配向量（每个字段对应一个列向量）
                    VarCharVector nameVector = (VarCharVector) vectorSchemaRoot.getVector("name");
                    IntVector ageVector = (IntVector) vectorSchemaRoot.getVector("age");
                    BigIntVector timestampVector = (BigIntVector) vectorSchemaRoot.getVector("timestamp");

                    // 分配内存（一次性分配足够存储一行数据的内存）
                    nameVector.allocateNew(rowCount);
                    ageVector.allocateNew(rowCount);
                    timestampVector.allocateNew(rowCount);

                    // 每秒生成新的 Map 数据并发送
                    for (int i = 0; i < 2; i++) {  // 假设我们只发送 10 次，循环次数可根据需求修改
                        Map<String, Object> mapData = new HashMap<>();
                        mapData.put("name", "User_" + i);  // 动态生成用户名称
                        mapData.put("age", 20 + i);        // 动态生成年龄
                        mapData.put("timestamp", System.currentTimeMillis()/1000);  // 当前时间戳

                        // 更新向量中的数据
                        nameVector.set(0, mapData.get("name").toString().getBytes());
                        ageVector.set(0, (Integer) mapData.get("age"));
                        timestampVector.set(0, (Long) mapData.get("timestamp"));

                        // 设置行数
                        vectorSchemaRoot.setRowCount(rowCount);

                        // 发送数据到服务器
                        listener.putNext();
                        System.out.println("Put data for User_" + i);

                        // 等待1秒钟再发送下一批数据
                        Thread.sleep(1000);
                    }

                    // 完成数据发送
                    listener.completed();
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
}