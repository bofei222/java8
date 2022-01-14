package com.bf.JVM;

/**
 * @description:
 * @author: bofei
 * @date: 2020-06-08 13:47
 **/
public class ByteCodeDemo {
    private int a = 1;

    public int add() {
        int b = 2;
        int c = a + b;
        System.out.println(c);
        return c;
    }
}
