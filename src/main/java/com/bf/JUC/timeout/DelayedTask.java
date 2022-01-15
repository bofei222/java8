package com.bf.JUC.timeout;

/**
 * @description:
 * @author: bofei
 * @date: 2022-01-12 11:47
 **/
public class DelayedTask implements Runnable{
    @Override
    public void run() {
        doTask();
    }

    public synchronized void doTask() {
        try {

            for (int i = 0; i < 100000000; i++) {
                wait(1);
//                            TimeUnit.MILLISECONDS.sleep(50);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("task end");
    }

}