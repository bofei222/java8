package com.bf.JUC.test;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @description:
 * @author: bofei
 * @date: 2022-09-19 16:39
 **/
public class Test {

    private static Integer count = 0;
    final BlockingQueue<Integer> bq = new ArrayBlockingQueue<Integer>(5);//容量为5的阻塞队列

    ArrayBlockingQueue<List<Map>> lists = new ArrayBlockingQueue<>(5);


    public static void main(String[] args)  {

        Test t = new Test();
        new Thread(t.new Producer()).start();
        new Thread(t.new Consumer()).start();
//        new Thread(t.new Consumer()).start();
//        new Thread(t.new Producer()).start();
    }
    class Producer implements Runnable {
        @Override
        public void run() {


            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    bq.put(1);
                    count++;
                    System.out.println(Thread.currentThread().getName() + "produce:: " + count);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
    class Consumer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                try {
                    Integer take = bq.take();
                    count--;
                    System.out.println(Thread.currentThread().getName()+ "consume:: " + count);
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
        }
    }
}
