package com.bf.JUC.executor;

import java.util.concurrent.*;

public class TestCall {
    private static ScheduledExecutorService timer = Executors.newScheduledThreadPool(100);

//    ScheduledThreadPoolExecutor
//    ThreadPoolExecutor
    public static void main(String[] args) {
        Executors.newScheduledThreadPool(100);
        Executors.newSingleThreadExecutor();
        Executors.newFixedThreadPool(1);
//        ScheduledFuture
//        FutureTask
//        Thread
//        Callable
        TimerTask timerTask = new TimerTask("1");// 类必须静态，不然报错，why？
        ScheduledFuture<?> scheduledFuture = timer.scheduleAtFixedRate(timerTask, 1000, 3000, TimeUnit.MILLISECONDS);
    }

    private static class TimerTask implements Runnable {
        private final String id;

        public TimerTask(String id) {
            this.id = id;
        }

        @Override
        public void run() {


        }
    }
}

