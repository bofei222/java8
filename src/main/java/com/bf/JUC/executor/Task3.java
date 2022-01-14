package com.bf.JUC.executor;


import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Task3  {
    public static void main(String[] args) {
        ScheduledExecutorService ses= Executors.newScheduledThreadPool(2);
        ses.scheduleAtFixedRate(new MyTimerTask("任务1"), 1, 1, TimeUnit.SECONDS);
        ses.scheduleAtFixedRate(new MyTimerTask("任务2"), 1, 2, TimeUnit.SECONDS);
        try {
            TimeUnit.SECONDS.sleep(10);
            /*10秒后停止任务*/
            ses.shutdown();//停止运行线程池上的所有runnable。
            System.out.print("--运行10秒停止--");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /*TimerTask实现Runable接口*/
    static class MyTimerTask extends java.util.TimerTask {
        String name;

        public MyTimerTask(String name) {
            this.name = name;
        }

        public void run() {
            System.out.println(Thread.currentThread().getName()+":"+ Calendar.getInstance().get(Calendar.SECOND) + "===" + name);
        }
    }

}


