package com.bf.algs;

import java.util.concurrent.Semaphore;

/**
 * @description:
 * @author: bofei
 * @date: 2024-04-11 11:16
 **/
class SemaphoreABC {

    private static Semaphore s1 = new Semaphore(1); //因为先执行线程A，所以这里设s1的计数器为1
    private static Semaphore s2 = new Semaphore(0);


    private void printABC(Semaphore currentThread, Semaphore nextThread) {
        while(true)
            try {
                currentThread.acquire();       //阻塞当前线程，即信号量的计数器减1为0
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(1000);
                nextThread.release();          //唤醒下一个线程，即信号量的计数器加1

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }
    private void printABC2(Semaphore currentThread, Semaphore nextThread) {
        while(true)
            try {
                currentThread.acquire();       //阻塞当前线程，即信号量的计数器减1为0
                System.out.println(Thread.currentThread().getName());
                nextThread.release();          //唤醒下一个线程，即信号量的计数器加1

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }

    public static void main(String[] args) throws InterruptedException {
        SemaphoreABC printer = new SemaphoreABC();
        new Thread(() -> {
            printer.printABC(s1, s2);
        }, "A").start();

        Thread.sleep(10);
        new Thread(() -> {
            printer.printABC2(s2,s1);
        }, "B").start();
        Thread.sleep(10);

    }
}