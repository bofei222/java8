package com.bf.JUC.timeout;

import java.util.concurrent.*;

/**
 * @description:
 * @author: bofei
 * @date: 2022-01-12 17:11
 **/
public class FutureDemo {

    public static void main(String[] args) {
        ExecutorService executor = new ScheduledThreadPoolExecutor(10000);
        while (true) {
            Future<?> future = executor.submit(new DelayedTask());
            try {
                future.get(2000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException | ExecutionException ignored) {
                System.out.println(11);
            } catch (TimeoutException e) {
                System.out.println("timeout");
                future.cancel(true);
            }
            System.out.println("main end");

        }

    }

}