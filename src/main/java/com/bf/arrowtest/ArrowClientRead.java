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

        Location location = Location.forGrpcInsecure("0.0.0.0", 33333);
        try (BufferAllocator allocator = new RootAllocator()) {
            try (FlightClient flightClient = FlightClient.builder(allocator, location).build()) {
                System.out.println("C1: Client (Location): Connected to " + location.getUri());



                // Get metadata information
                FlightInfo flightInfo = flightClient.getInfo(FlightDescriptor.path("profiles"));
                System.out.println("C3: Client (Get Metadata): " + flightInfo);

                // Get data information
                try (FlightStream flightStream = flightClient.getStream(flightInfo.getEndpoints().get(0).getTicket())) {
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
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
