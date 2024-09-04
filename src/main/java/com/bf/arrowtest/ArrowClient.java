package com.bf.arrowtest;

import org.apache.arrow.flight.*;
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.util.AutoCloseables;
import org.apache.arrow.vector.VectorLoader;
import org.apache.arrow.vector.VectorSchemaRoot;
import org.apache.arrow.vector.VectorUnloader;
import org.apache.arrow.vector.ipc.message.ArrowRecordBatch;
import org.apache.arrow.vector.types.pojo.Schema;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @description:
 * @author: bofei
 * @date: 2024-09-03 17:51
 **/
public class ArrowClient {
}
class Dataset implements AutoCloseable {
    private final List<ArrowRecordBatch> batches;
    private final Schema schema;
    private final long rows;
    public Dataset(List<ArrowRecordBatch> batches, Schema schema, long rows) {
        this.batches = batches;
        this.schema = schema;
        this.rows = rows;
    }
    public List<ArrowRecordBatch> getBatches() {
        return batches;
    }
    public Schema getSchema() {
        return schema;
    }
    public long getRows() {
        return rows;
    }
    @Override
    public void close() throws Exception {
        AutoCloseables.close(batches);
    }
}
class CookbookProducer extends NoOpFlightProducer implements AutoCloseable {
    private final BufferAllocator allocator;
    private final Location location;
    private final ConcurrentMap<FlightDescriptor, Dataset> datasets;
    public CookbookProducer(BufferAllocator allocator, Location location) {
        this.allocator = allocator;
        this.location = location;
        this.datasets = new ConcurrentHashMap<>();
    }
    @Override
    public Runnable acceptPut(CallContext context, FlightStream flightStream, StreamListener<PutResult> ackStream) {
        List<ArrowRecordBatch> batches = new ArrayList<>();
        return () -> {
            long rows = 0;
            VectorUnloader unloader;
            while (flightStream.next()) {
                unloader = new VectorUnloader(flightStream.getRoot());
                final ArrowRecordBatch arb = unloader.getRecordBatch();
                batches.add(arb);
                rows += flightStream.getRoot().getRowCount();
            }
            Dataset dataset = new Dataset(batches, flightStream.getSchema(), rows);
            datasets.put(flightStream.getDescriptor(), dataset);
            ackStream.onCompleted();
        };
    }

    @Override
    public void getStream(CallContext context, Ticket ticket, ServerStreamListener listener) {
        FlightDescriptor flightDescriptor = FlightDescriptor.path(
                new String(ticket.getBytes(), StandardCharsets.UTF_8));
        Dataset dataset = this.datasets.get(flightDescriptor);
        if (dataset == null) {
            throw CallStatus.NOT_FOUND.withDescription("Unknown descriptor").toRuntimeException();
        }
        try (VectorSchemaRoot root = VectorSchemaRoot.create(
                this.datasets.get(flightDescriptor).getSchema(), allocator)) {
            VectorLoader loader = new VectorLoader(root);
            listener.start(root);
            for (ArrowRecordBatch arrowRecordBatch : this.datasets.get(flightDescriptor).getBatches()) {
                loader.load(arrowRecordBatch);
                listener.putNext();
            }
            listener.completed();
        }
    }

    @Override
    public void doAction(CallContext context, Action action, StreamListener<Result> listener) {
        FlightDescriptor flightDescriptor = FlightDescriptor.path(
                new String(action.getBody(), StandardCharsets.UTF_8));
        switch (action.getType()) {
            case "DELETE": {
                Dataset removed = datasets.remove(flightDescriptor);
                if (removed != null) {
                    try {
                        removed.close();
                    } catch (Exception e) {
                        listener.onError(CallStatus.INTERNAL
                                .withDescription(e.toString())
                                .toRuntimeException());
                        return;
                    }
                    Result result = new Result("Delete completed".getBytes(StandardCharsets.UTF_8));
                    listener.onNext(result);
                } else {
                    Result result = new Result("Delete not completed. Reason: Key did not exist."
                            .getBytes(StandardCharsets.UTF_8));
                    listener.onNext(result);
                }
                listener.onCompleted();
            }
        }
    }

    @Override
    public FlightInfo getFlightInfo(CallContext context, FlightDescriptor descriptor) {
        FlightEndpoint flightEndpoint = new FlightEndpoint(
                new Ticket(descriptor.getPath().get(0).getBytes(StandardCharsets.UTF_8)), location);
        return new FlightInfo(
                datasets.get(descriptor).getSchema(),
                descriptor,
                Collections.singletonList(flightEndpoint),
                /*bytes=*/-1,
                datasets.get(descriptor).getRows()
        );
    }

    @Override
    public void listFlights(CallContext context, Criteria criteria, StreamListener<FlightInfo> listener) {
        datasets.forEach((k, v) -> { listener.onNext(getFlightInfo(null, k)); });
        listener.onCompleted();
    }

    @Override
    public void close() throws Exception {
        AutoCloseables.close(datasets.values());
    }
}