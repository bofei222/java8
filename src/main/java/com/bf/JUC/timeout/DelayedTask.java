package com.bf.JUC.timeout;

/**
 * @description:
 * @author: bofei
 * @date: 2022-01-12 11:47
 **/
public class DelayedTask {

    public static int doTask() {
        try {
//            TimeUnit.MILLISECONDS.sleep(50);
//            for (int i = 0; i < 1000000; i++) {
//                System.out.println();
//                if (Thread.currentThread().isInterrupted()) {
//                    Thread.sleep(1);
//                }
//            }
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task end");
        return 1;
    }

}