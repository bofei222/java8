package com.bf.JUC.thread.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: bofei
 * @date: 2022-12-05 11:31
 **/
public class CompletableFutureTest {

    CountDownLatch waitLatch = new CountDownLatch(1);

    CompletableFuture<?> future = CompletableFuture.runAsync(() -> {
        try {
            System.out.println("Wait");
            waitLatch.await(); //cancel should interrupt
            System.out.println("Done");
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
            throw new RuntimeException(e);
        }
    });

//    sleep(10); //give it some time to start (ugly, but works)
//future.cancel(true);
//System.out.println("Cancel called");

//    assertTrue(future.isCancelled());
//
//    assertTrue(future.isDone());
//    sleep(100); //give it some time to finish
}
