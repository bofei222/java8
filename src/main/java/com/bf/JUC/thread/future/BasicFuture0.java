package com.bf.JUC.thread.future;

import java.util.concurrent.*;

/**
 * @Author bofei
 * @Date 2019/7/7 14:31
 * @Description
 */
public class BasicFuture0 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(1);
        Future<Integer> f = es.submit(() -> {
            // 长时间的异步计算
            // ……
            // 然后返回结果
            Thread.sleep(2990);
            return 1;
        });
//        while (!f.isDone()) {
//
//        }
        System.out.println("11");
        ;
        try {
            Integer integer = f.get(3, TimeUnit.SECONDS);
            System.out.println(integer);
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println("22");
    //如果不调用线程池对象的shutdown方法，当线程池里面的任务执行完毕后主线程这个JVM不会退出。
        es.shutdown();
    }
}