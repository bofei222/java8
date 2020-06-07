package com.bf.JUC.executor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * @author bofei
 * @date 2018/11/7 18:39
 */
public class ScheduledExecutorServiceTest {
    static ScheduledExecutorService timer = Executors.newSingleThreadScheduledExecutor();
    public static void main(String[] args) throws Exception {

        ScheduledExecutorService pool = Executors.newScheduledThreadPool(100);
        ExecutorService executorService = Executors.newFixedThreadPool(100);

//        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(100);

        TimerTask timerTask = new TimerTask("a"); // 任务需要 2000 ms 才能执行完毕
        TimerTask timerTask2 = new TimerTask("b"); // 任务需要 2000 ms 才能执行完毕

        System.out.printf("起始时间：%s\n\n", new SimpleDateFormat("HH:mm:ss").format(new Date()));

        // 延时 1 秒后，按 3 秒的周期执行任务
        ScheduledFuture<?> scheduledFuture = timer.scheduleAtFixedRate(timerTask, 1000, 4000, TimeUnit.MILLISECONDS);
        ScheduledFuture<?> scheduledFuture2 = timer.scheduleAtFixedRate(timerTask2, 1000, 2000, TimeUnit.MILLISECONDS);

        ScheduledFuture<String> schedule = timer.schedule(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return null;
            }
        }, 1, TimeUnit.SECONDS);

    }

    public static String test() {
        System.out.println("模拟任务运行...");
        return "2";
    }

    private static class TimerTask implements Runnable {

        private final String name;
        private final SimpleDateFormat dateFormat;
        String test = "1";

        public TimerTask(String name) {
            this.name = name;
            dateFormat = new SimpleDateFormat("HH:mm:ss");
        }

        @Override
        public void run() {

            if (test.equals("1")) {
                System.out.println("任务开始，当前时间：" + dateFormat.format(new Date()) + "===" + name);
                test = test();
            } else {
                System.out.println("任务结束" + name);
                throw new RuntimeException("任务结束");
            }
//            System.out.println("任务结束，当前时间：" + dateFormat.format(new Date()));
            System.out.println();
        }
    }
}

