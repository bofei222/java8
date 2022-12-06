package com.bf.JUC.thread.completableFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @description:
 * @author: bofei
 * @date: 2022-12-01 22:00
 **/
public class CompletableFutureTimeout2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
////        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
////            try {
////                Thread.sleep(20000);
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            }
////            return 10;
////        });
////
////        CompletableFuture<Integer> within = CompletableFutureTimeout.completeOnTimeout(1, future, 1, TimeUnit.SECONDS);
////        System.out.println(within.get());
//
//
//        CompletableFuture<String> futureStr = CompletableFuture.supplyAsync(() -> {
//            try {
//                while (true) {
//                    if (Thread.currentThread().isInterrupted()) {
//                        System.out.println("被退出");
//                        break;
//                    }else {
//                        Thread.sleep(1000);
//                        System.out.println("running");
//                    }
//                }
//
//
//                System.out.println(111);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "正常执行";
//        }, new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new SynchronousQueue<>(), new ThreadFactory() {
//            AtomicInteger auto = new AtomicInteger();
//            @Override
//            public Thread newThread(Runnable r) {
//                Thread thread = new Thread(r);
//
//                thread.setName("xx"+ auto.incrementAndGet());
//                return thread;
//            }
//        }));
//
//        CompletableFuture<String> withinStr = CompletableFutureTimeout.completeOnTimeout("异常执行", futureStr, 10000, TimeUnit.MILLISECONDS);
//        Thread thread = new Thread();
//        thread.interrupt();
//
//        System.out.println(withinStr.get());
//        withinStr.cancel(true);
//        if (withinStr.isCancelled()) {
//            System.out.println("withinStr, canceled");
//        }
//        futureStr.cancel(true);
//        if (futureStr.isCancelled()) {
//            System.out.println(true);
//        }
//        if (futureStr.isDone()) {
//            System.out.println("futureStr, done");
//        }
//        System.out.println();


        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<?> submit = executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println();

            }
        });

        submit.cancel(true);

    }



}