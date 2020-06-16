package com.bf.JUC.thread;

public class RunnableDemo  {
    public void test() {

    }

    public static void main(String[] args) {
        new Thread().start();
        RunnableDemo rd = new RunnableDemo(){
            @Override
          public void test() {
              System.out.println("我是重写,我不想写新类，但是我想重写");
          }
        };

        rd.test();

        Thread t = new Thread() {
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    System.out.print(i + " ");
                }
            }
        };
        t.start();
    }

    public static void main2(String[] args) {
        Runnable r = new Runnable() {
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    System.out.print(i + " ");
                }
            }
        };
        Thread t = new Thread(r);
        t.start();
    }
}
