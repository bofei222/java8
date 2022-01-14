package com.bf.java8;

/**
 *
 */
public class FunctionInterfaceDemo {
    public static void main(String[] args) {
        // 匿名函数
        Thread thread = new Thread(new Runnable() {
            public void run() {
                System.out.println("In another thread");
            }
        });

        // 匿名内部类
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                super.run();
            }
        };


        thread.start();

        System.out.println("In main");

        Runnable r = () -> System.out.println("In another thread"); // lambda表达式的类型是一个接口，lambda表达式（那段代码）是对这个接口的实现
        Thread thread2 = new Thread(r);
    }
}
