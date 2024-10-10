package com.bf.arrowtest;

import org.apache.arrow.vector.*;
import org.apache.arrow.vector.types.pojo.*;
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.memory.RootAllocator;
import org.apache.arrow.flight.*;

import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * 示例：将 Map 数据转换为 Arrow 向量并通过 Flight 传递
 */
public class ArrowServerWithMap {
    public static void main(String[] args) {
        // 设置服务器位置
        Location location = Location.forGrpcInsecure("0.0.0.0", 33333);
        try (BufferAllocator allocator = new RootAllocator()) {
            // 服务器构建
            try (final CookbookProducer producer = new CookbookProducer(allocator, location);
                 final FlightServer flightServer = FlightServer.builder(allocator, location, producer).build()) {

                flightServer.start();
                System.out.println("S1: Server (Location): Listening on port " + flightServer.getPort());

                // 客户端连接到服务器
                try (FlightClient flightClient = FlightClient.builder(allocator, location).build()) {
                    System.out.println("C1: Client (Location): Connected to " + location.getUri());

                    // 定义 Schema，包括 name、age、email 字段
                    Schema schema = new Schema(Arrays.asList(
                            new Field("name", FieldType.nullable(new ArrowType.Utf8()), null),
                            new Field("age", FieldType.nullable(new ArrowType.Int(32, true)), null),
                            new Field("email", FieldType.nullable(new ArrowType.Utf8()), null)
                    ));

                    // 创建并分配向量
                    try (VectorSchemaRoot vectorSchemaRoot = VectorSchemaRoot.create(schema, allocator);
                         VarCharVector nameVector = (VarCharVector) vectorSchemaRoot.getVector("name");
                         IntVector ageVector = (IntVector) vectorSchemaRoot.getVector("age");
                         VarCharVector emailVector = (VarCharVector) vectorSchemaRoot.getVector("email")) {

                        // 准备数据
                        List<Map<String, Object>> dataList = new ArrayList<>();
                        Map<String, Object> row1 = new HashMap<>();
                        row1.put("name", "Ronald");
                        row1.put("age", 30);
                        row1.put("email", "ronald@example.com");

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

                        // 设置每一行的数据
                        int rowIndex = 0;
                        nameVector.allocateNew(dataList.size());
                        ageVector.allocateNew(dataList.size());
                        emailVector.allocateNew(dataList.size());

                        for (Map<String, Object> row : dataList) {
                            // 提取并转换数据
                            nameVector.set(rowIndex, ((String) row.get("name")).getBytes(StandardCharsets.UTF_8));
                            ageVector.set(rowIndex, (int) row.get("age"));
                            emailVector.set(rowIndex, ((String) row.get("email")).getBytes(StandardCharsets.UTF_8));
                            rowIndex++;
                        }

                        // 设置行数
                        vectorSchemaRoot.setRowCount(dataList.size());

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
}
