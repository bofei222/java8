package com.bf.arrowtest;

import org.apache.arrow.flight.*;
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.memory.RootAllocator;
import org.apache.arrow.vector.BigIntVector;
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
public class ArrowServerWrite {
    public static void main(String[] args) {
        Location location = Location.forGrpcInsecure("10.162.4.45", 8815);
        try (BufferAllocator allocator = new RootAllocator()) {

            // Client
            try (FlightClient flightClient = FlightClient.builder(allocator, location).build()) {
                System.out.println("C1: Client (Location): Connected to " + location.getUri());


                Schema schema = new Schema(Arrays.asList(
                        new Field("name", FieldType.nullable(new ArrowType.Utf8()), null),
                        new Field("timestamp", FieldType.nullable(new ArrowType.Int(64, true)), null)

                ));
                try (VectorSchemaRoot vectorSchemaRoot = VectorSchemaRoot.create(schema, allocator);
                ) {
                    VarCharVector varCharVector = (VarCharVector) vectorSchemaRoot.getVector("name");
                    BigIntVector intVector = (BigIntVector) vectorSchemaRoot.getVector("timestamp");

                    varCharVector.allocateNew(1);
                    intVector.allocateNew(1);

                    varCharVector.set(0, "Ronald".getBytes());
                    intVector.set(0, System.currentTimeMillis());
                    vectorSchemaRoot.setRowCount(1);

                    FlightClient.ClientStreamListener listener = flightClient.startPut(
                            FlightDescriptor.path("file_realtime_001_schema888"),
                            vectorSchemaRoot, new AsyncPutListener());
                    listener.putNext();

//                        varCharVector.set(0, "bofei".getBytes());
//                        intVector.set(0, System.currentTimeMillis());
//                        vectorSchemaRoot.setRowCount(1);
//
//                        listener.putNext();
//                    listener.completed();
//                    listener.getResult();
                    System.out.println("C2: Client (Populate Data): Wrote 2 batches with 3 rows each");
                }


                Thread.sleep(1000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
