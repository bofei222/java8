package com.bf.arrowtest;

import org.apache.arrow.flight.*;
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.memory.RootAllocator;
import org.apache.arrow.vector.IntVector;
import org.apache.arrow.vector.VarCharVector;
import org.apache.arrow.vector.VectorSchemaRoot;
import org.apache.arrow.vector.types.pojo.ArrowType;
import org.apache.arrow.vector.types.pojo.Field;
import org.apache.arrow.vector.types.pojo.FieldType;
import org.apache.arrow.vector.types.pojo.Schema;

import java.util.Arrays;

/**
 * @description:
 * @author: bofei
 * @date: 2024-09-03 17:51
 **/
public class ArrowClient {
    public static void main(String[] args) {
//        Location location = Location.forGrpcInsecure("0.0.0.0", 33333);
        Location location = Location.forGrpcInsecure("10.162.4.45", 8815);
        try (BufferAllocator allocator = new RootAllocator()) {
            // Server
            try (final CookbookProducer producer = new CookbookProducer(allocator, location);
                 final FlightServer flightServer = FlightServer.builder(allocator, location, producer).build()) {
              /*  try {
                    flightServer.start();
                    System.out.println("S1: Server (Location): Listening on port " + flightServer.getPort());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }*/
                // Client
                try (FlightClient flightClient = FlightClient.builder(allocator, location).build()) {
                    System.out.println("C1: Client (Location): Connected to " + location.getUri());



                    // 定义 Schema，增加多个字段，如 name（字符串），age（整数），email（字符串）
                    Schema schema = new Schema(Arrays.asList(
                            new Field("name", FieldType.nullable(new ArrowType.Utf8()), null),
                            new Field("timestamp", FieldType.nullable(new ArrowType.Int(32, true)), null),
                            new Field("email", FieldType.nullable(new ArrowType.Utf8()), null)
                    ));

                    try (VectorSchemaRoot vectorSchemaRoot = VectorSchemaRoot.create(schema, allocator);
                         ) {


                        FlightClient.ClientStreamListener listener = flightClient.startPut(
                                FlightDescriptor.path("file_realtime_001_schema111"),
                                vectorSchemaRoot, new AsyncPutListener());



                        VarCharVector nameVector = (VarCharVector) vectorSchemaRoot.getVector("name");
                        IntVector ageVector = (IntVector) vectorSchemaRoot.getVector("timestamp");
                        VarCharVector emailVector = (VarCharVector) vectorSchemaRoot.getVector("email");


                        // 为每个字段分配内存
                        nameVector.allocateNew(1);
                        ageVector.allocateNew(1);
                        emailVector.allocateNew(1);


                        // 设置第一个批次的数据
                        nameVector.set(0, "Ronald".getBytes());
                        ageVector.set(0, (int) (System.currentTimeMillis()/1000));
                        emailVector.set(0, "ronald@example.com".getBytes());


                        vectorSchemaRoot.setRowCount(1);
                        listener.putNext();


////                        // 为每个字段分配内存
//                        nameVector.allocateNew(3);
//                        ageVector.allocateNew(3);
//                        emailVector.allocateNew(3);


                        // 设置第二个批次的数据
                        nameVector.set(0, "Ronald2".getBytes());
                        ageVector.set(0, (int) (System.currentTimeMillis()/1000));
                        emailVector.set(0, "ronald@example.com".getBytes());


                        vectorSchemaRoot.setRowCount(1);
                        listener.putNext();

                        // 设置第3个批次的数据
                        nameVector.set(0, "Ronald3".getBytes());
                        ageVector.set(0, (int) (System.currentTimeMillis()/1000));
                        emailVector.set(0, "ronald@example.com".getBytes());


                        vectorSchemaRoot.setRowCount(1);
                        listener.putNext();

                        listener.completed();
//                        listener.getResult();
                        System.out.println("C2: Client (Populate Data): Wrote 2 batches with 3 rows each");
                    }

                    // Get metadata information
//                    FlightInfo flightInfo = flightClient.getInfo(FlightDescriptor.path("file_BFFC_001_schema001"));
//                    System.out.println("C3: Client (Get Metadata): " + flightInfo);

                    // Get data information memory_BFFC_0001_schema001
                    //   file_realtime_001_2024-09-26
                    Thread.sleep(1000);
                    try (FlightStream flightStream = flightClient.getStream(new Ticket("memory_realtime_001_schema111".getBytes()))) {
                        int batch = 0;
                        try (VectorSchemaRoot vectorSchemaRootReceived = flightStream.getRoot()) {
                            System.out.println("C4: Client (Get Stream):");
                            while (flightStream.next()) {
                                batch++;
                                System.out.println("Client Received batch #" + batch + ", Data:");
                                System.out.print(vectorSchemaRootReceived.contentToTSVString());
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    /*// Get all metadata information
                    Iterable<FlightInfo> flightInfosBefore = flightClient.listFlights(Criteria.ALL);
                    System.out.print("C5: Client (List Flights Info): ");
                    flightInfosBefore.forEach(t -> System.out.println(t));

                    // Do delete action
                    Iterator<Result> deleteActionResult = flightClient.doAction(new Action("DELETE",
                            FlightDescriptor.path("profiles").getPath().get(0).getBytes(StandardCharsets.UTF_8)));
                    while (deleteActionResult.hasNext()) {
                        Result result = deleteActionResult.next();
                        System.out.println("C6: Client (Do Delete Action): " +
                                new String(result.getBody(), StandardCharsets.UTF_8));
                    }

                    // Get all metadata information (to validate detele action)
                    Iterable<FlightInfo> flightInfos = flightClient.listFlights(Criteria.ALL);
                    flightInfos.forEach(t -> System.out.println(t));
                    System.out.println("C7: Client (List Flights Info): After delete - No records");
*/
                    // Server shut down
                    flightServer.shutdown();
                    System.out.println("C8: Server shut down successfully");
                }

//                Thread.sleep(900000000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
