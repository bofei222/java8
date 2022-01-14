package com.bf.JUC.thread;

public class Web12307 implements Runnable {

    private int num = 10;
    

    @Override
    public void run() {
        payTicket();
    }

    public synchronized void payTicket() {
        while (true) {
            if (num <= 0) {
                break;
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "抢到了" + num--);
        }

    }

    public static void main(String[] args) {
        Web12307 web12306 = new Web12307();
        Thread t1 = new Thread(web12306, "路人甲");
        Thread t2 = new Thread(web12306, "黄牛乙");
        Thread t3 = new Thread(web12306, "程序员");
        t1.start();
        t2.start();
        t3.start();
    }
}
