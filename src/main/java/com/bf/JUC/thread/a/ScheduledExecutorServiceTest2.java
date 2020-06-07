package com.bf.JUC.thread.a;

import java.util.concurrent.*;

/**
 * @description:
 * @author: bofei
 * @date: 2020-01-02 13:28
 **/
public class ScheduledExecutorServiceTest2 {
    static ScheduledExecutorService timer = Executors.newSingleThreadScheduledExecutor();

    public static void main(String[] args) throws InterruptedException {


        ScheduledFuture<?> future = timer.schedule(new Runnable() {
            @Override
            public void run() {

                System.out.println("关闭");
            }
        }, 2, TimeUnit.SECONDS);
        System.out.println("主线程");
//        Thread.sleep(1000);
//        future.cancel(false);
//        future.cancel(true);
    }
}
