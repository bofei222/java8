package com.bf.JUC.thread.a;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @description:
 * @author: bofei
 * @date: 2020-01-02 13:28
 **/
public class ExecutorServiceTest2 {
    // 之前为什么 不并发执行，因为这里设置了1，只有一个线程
    static ExecutorService executorService = Executors.newFixedThreadPool(2);

    static Map<String, Future> map = new HashMap<>();
    public static void main(String[] args) throws InterruptedException, ExecutionException {


    Future<?> future = executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("任务线程1开始");
                    Thread.sleep(3000);
                    System.out.println("任务线程1结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        map.put("1", future);

//        Thread.sleep(1000);
//        future.cancel(false);



        Future<?> future2 = executorService.submit(new Runnable() {
            @Override
            public void run() {
                Future future1 = map.get("1");

                System.out.println(future1.cancel(true));;
                System.out.println("取消任务1");

            }
        });

        executorService.shutdown();
        System.out.println("end");

    }
}
