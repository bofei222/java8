package com.bf.JUC.timeout;

/**
 * @description:
 * @author: bofei
 * @date: 2022-01-12 11:47
 **/
public class JoinDemo {

    public static void main(String[] args) {
        Thread t = new Thread(DelayedTask::doTask);
        t.start();
        try {
            t.join(20); // join 不会抛出超时异常
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (t.isAlive()) {
            System.out.println("timeout");
            t.interrupt();
        }
    }

}