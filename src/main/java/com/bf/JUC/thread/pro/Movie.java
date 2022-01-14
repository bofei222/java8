package com.bf.JUC.thread.pro;

public class Movie {
    private String pic;
    private Boolean flag = true;

    public synchronized void play(String pic) {
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 开始生产
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 生产完毕
        this.pic = pic;
        System.out.println("生产了" + pic);
        // 通知消费
        this.notify();
        // 生产者停下
        this.flag = false;

    }

    public synchronized void watch() {
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 开始消费
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("消费了" + pic);
        // 消费完毕
        // 通知生产
        this.notify();
        // 消费停止
        this.flag = true;

    }
}
