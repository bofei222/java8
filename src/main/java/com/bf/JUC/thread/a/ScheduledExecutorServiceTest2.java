package com.bf.JUC.thread.a;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @description:
 * @author: bofei
 * @date: 2020-01-02 13:28
 **/
public class ScheduledExecutorServiceTest2 {
    static ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    static Map<String, Future> map = new HashMap<>();
    public static void main(String[] args) throws InterruptedException {


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

        System.out.println("主线程");
//        Thread.sleep(1000);
//        future.cancel(false);



        Future<?> future2 = executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("任务线程2开始");
                Future future1 = map.get("1");

                System.out.println(future1.cancel(true));;
                System.out.println("取消任务1");
                System.out.println("任务线程2开始");
            }
        });


        System.out.println("end");


    }
}
