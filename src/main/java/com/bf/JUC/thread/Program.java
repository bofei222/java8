package com.bf.JUC.thread;

/**
 * 实现Runnable 重写run()
 * 1）避免单继承局限性
 * 2）共享资源
 */
public class Program implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("一边敲hello world..");
        }
    }
}
