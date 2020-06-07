package com.bf.JUC.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Web12308 implements Runnable {

    private int num = 10;
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            //
            lock.lock();
            if (num <= 0) {
                break;
            }
            try {
                Thread.sleep(10);
                System.out.println(Thread.currentThread().getName() + "抢到了" + num--);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Web12308 web12306 = new Web12308();
        Thread t1 = new Thread(web12306, "路人甲");
        Thread t2 = new Thread(web12306, "黄牛乙");
        Thread t3 = new Thread(web12306, "程序员");
        t1.start();
        t2.start();
        t3.start();
    }
}
