package com.bf.JUC.thread;

/**
 * @author bofei
 * @date 2018/9/28 10:11
 */
public class Web12309 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread t1 = new Thread(myThread, "路人甲");
        Thread t2 = new Thread(myThread, "黄牛乙");
        Thread t3 = new Thread(myThread, "程序员");
        t1.start();
        t2.start();
        t3.start();
    }
}
class MyThread implements Runnable {
    int i = 0;
    @Override
    public void run() {
        while (i < 50) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            i++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
