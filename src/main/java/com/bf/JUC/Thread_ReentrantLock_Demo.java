package com.bf.JUC;

import java.util.concurrent.locks.ReentrantLock;

public class Thread_ReentrantLock_Demo {
    public static ReentrantLock lock = new ReentrantLock();
    private static boolean flag = false;

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                lock.lock();
                while (!flag) {
                    if (flag) {
                        break;
                    }
                }
                lock.unlock();
            }, "thread-"+i).start();
        }

    }
}
