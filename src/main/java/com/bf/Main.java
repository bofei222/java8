package com.bf;

import java.text.SimpleDateFormat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Runnable helloRunnable = new Runnable() {
            public void run() {

                try {
                    Thread.sleep(1001);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        };

        // 单个任务是排队执行的
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(helloRunnable, 0, 1, TimeUnit.SECONDS);
    }


}
