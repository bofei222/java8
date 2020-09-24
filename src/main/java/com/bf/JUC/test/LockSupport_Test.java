package com.bf.JUC.test;

/**
 * @description:
 * @author: bofei
 * @date: 2020-09-18 20:22
 **/
public class LockSupport_Test {
    public static void main(String[] args) {
        char[] c1 = "123456".toCharArray();
        char[] c2 = "ABCDE".toCharArray();
        Thread t1 = new Thread(() -> {
            for (char c : c1) {
                System.out.println(c);
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            for (char c : c2) {
                System.out.println(c);
            }
        }, "t2");
        t1.start();
        t2.start();
    }
}
