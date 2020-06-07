package com.bf.JUC.thread;

/**
 * 继承Thread 重写run()
 */
public class Rabbit extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("兔子跑了" + i + "步");
        }
    }
}

class Tortoies extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("乌龟跑了" + i + "步");
        }
    }
}
