package com.bf.JUC.executor;

import java.util.TimerTask;

/**
 * @author bofei
 * @date 2018/11/8 12:27
 */
public class TimerWhile {
    private static boolean flag = true;
    public static void main(String[] args) throws InterruptedException {
        while(true) {

            System.out.println("睡1分钟");
            Thread.sleep(3000 );
            if (flag) {
                // 1分钟执行一次
                System.out.println("执行任务");
                // flag = false;
            } else {
                System.out.println("结束任务");
                break;
            }
        }
        System.out.println("结束main");
    }

    static class MyTask extends TimerTask  {

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (true) {

                    System.out.println("执行任务");

            }
        }
    }
}
