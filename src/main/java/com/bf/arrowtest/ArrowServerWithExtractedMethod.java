package com.bf.arrowtest;

import org.apache.arrow.flight.*;
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.memory.RootAllocator;
import org.apache.arrow.vector.*;
import org.apache.arrow.vector.types.pojo.*;
import org.apache.arrow.vector.types.pojo.ArrowType;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class ArrowServerWithExtractedMethod {
    public static void main(String[] args) {
        // 设置服务器位置
        Location location = Location.forGrpcInsecure("0.0.0.0", 33333);
        Location location2 = Location.forGrpcInsecure("10.162.4.45", 8815);
        try (BufferAllocator allocator = new RootAllocator()) {
            // 服务器构建
            try (final CookbookProducer producer = new CookbookProducer(allocator, location);
                 final FlightServer flightServer = FlightServer.builder(allocator, location, producer).build()) {

                flightServer.start();
                System.out.println("S1: Server (Location): Listening on port " + flightServer.getPort());

                // 客户端连接到服务器
                try (FlightClient flightClient = FlightClient.builder(allocator, location2).build()) {
                    System.out.println("C1: Client (Location): Connected to " + location2.getUri());

                    // 准备数据列表
                    List<Map<String, Object>> dataList = prepareData();

                    // 动态生成 Schema
                    Schema schema = generateSchemaFromMap(dataList.get(0));
                    System.out.println("Generated Schema: " + schema);

                    // 创建并分配向量
                    try (VectorSchemaRoot vectorSchemaRoot = VectorSchemaRoot.create(schema, allocator)) {
                        // 将 map 转换为 Arrow Vector 并填充数据
                        fillDataIntoArrowVector(dataList, schema, vectorSchemaRoot);

                        // 通过 FlightClient 向服务器发送数据
                        FlightClient.ClientStreamListener listener = flightClient.startPut(
                                FlightDescriptor.path("profiles"),
                                vectorSchemaRoot, new AsyncPutListener());
                        listener.putNext();
                        listener.completed();
                        listener.getResult();

                        System.out.println("C2: Client (Put Data): Wrote 1 batch with " + dataList.size() + " rows");

                        // 从服务器获取数据
                        FlightInfo flightInfo = flightClient.getInfo(FlightDescriptor.path("profiles"));
                        try (FlightStream flightStream = flightClient.getStream(flightInfo.getEndpoints().get(0).getTicket())) {
                            int batch = 0;
                            try (VectorSchemaRoot vectorSchemaRootReceived = flightStream.getRoot()) {
                                while (flightStream.next()) {
                                    batch++;
                                    System.out.println("Client Received batch #" + batch + ", Data:");
                                    System.out.print(vectorSchemaRootReceived.contentToTSVString());
                                }
                            }
                        }
                    }
                }

                // 关闭服务器
                flightServer.shutdown();
                System.out.println("C3: Server shut down successfully");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 生成数据列表
    private static List<Map<String, Object>> prepareData() {
        List<Map<String, Object>> dataList = new ArrayList<>();
        Map<String, Object> row1 = new HashMap<>();
        row1.put("name", "Ronald");
        row1.put("age", 30);
        row1.put("email", "ronald@example.com");
        row1.put("timestamp", "ronald@example.com");

        Map<String, Object> row2 = new HashMap<>();
        row2.put("name", "David");
        row2.put("age", 25);
        row2.put("email", "david@example.com");

        Map<String, Object> row3 = new HashMap<>();
        row3.put("name", "Francisco");
        row3.put("age", 28);
        row3.put("email", "francisco@example.com");

        dataList.add(row1);
        dataList.add(row2);
        dataList.add(row3);

        return dataList;
    }

    // 根据 Map 中的键动态生成 Schema
    private static Schema generateSchemaFromMap(Map<String, Object> map) {
        List<Field> fields = new ArrayList<>();
        for (String key : map.keySet()) {
            Object value = map.get(key);
            if (value instanceof String) {
                fields.add(new Field(key, FieldType.nullable(new ArrowType.Utf8()), null));
            } else if (value instanceof Integer) {
                fields.add(new Field(key, FieldType.nullable(new ArrowType.Int(32, true)), null));
            }
            // 根据需要添加其他数据类型的支持
        }
        return new Schema(fields);
    }

    // 将 Map 数据填充到 Arrow Vector 中
    private static void fillDataIntoArrowVector(List<Map<String, Object>> dataList, Schema schema, VectorSchemaRoot vectorSchemaRoot) {
        Map<String, FieldVector> vectorMap = new HashMap<>();
        for (Field field : schema.getFields()) {
            FieldVector vector = vectorSchemaRoot.getVector(field.getName());
            vector.allocateNew();
            vectorMap.put(field.getName(), vector);
        }

        // 填充数据
        int rowIndex = 0;
        for (Map<String, Object> row : dataList) {
            for (String key : row.keySet()) {
                FieldVector vector = vectorMap.get(key);
                if (vector instanceof VarCharVector) {
                    ((VarCharVector) vector).set(rowIndex, ((String) row.get(key)).getBytes(StandardCharsets.UTF_8));
                } else if (vector instanceof IntVector) {
                    ((IntVector) vector).set(rowIndex, (int) row.get(key));
                }
            }
            rowIndex++;
        }

        // 设置行数
        vectorSchemaRoot.setRowCount(dataList.size());
    }
}
