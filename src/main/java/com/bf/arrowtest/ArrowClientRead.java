package com.bf.arrowtest;

import org.apache.arrow.flight.*;
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.memory.RootAllocator;
import org.apache.arrow.vector.VectorSchemaRoot;

/**
 * @description:
 * @author: bofei
 * @date: 2024-09-03 17:51
 **/
public class ArrowClientRead {
    public static void main(String[] args) {
//        Location location = Location.forGrpcInsecure("0.0.0.0", 33333);
        Location location = Location.forGrpcInsecure("10.19.8.243", 8815);
        try (BufferAllocator allocator = new RootAllocator()) {
            // Server
            try (final CookbookProducer producer = new CookbookProducer(allocator, location);) {
              /*  try {
                    flightServer.start();
                    System.out.println("S1: Server (Location): Listening on port " + flightServer.getPort());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }*/
                // Client
                try (FlightClient flightClient = FlightClient.builder(allocator, location).build()) {
                    System.out.println("C1: Client (Location): Connected to " + location.getUri());





                    // Get metadata information
//                    FlightInfo flightInfo = flightClient.getInfo(FlightDescriptor.path("file_BFFC_001_schema001"));
//                    System.out.println("C3: Client (Get Metadata): " + flightInfo);

                    // Get data information memory_BFFC_0001_schema001
                    //   file_realtime_001_2024-09-26
                    Thread.sleep(1000); // memory_realtime_001_schema888   memory_realtime_001_schema111
                    try (FlightStream flightStream = flightClient.getStream(new Ticket("memory_realtime_001_schema888".getBytes()))) {
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
                    Thread.sleep(100); // memory_realtime_001_schema888   memory_realtime_001_schema111
                    // Server shut down

                    System.out.println("C8: Server shut down successfully");
                }

//                Thread.sleep(900000000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
