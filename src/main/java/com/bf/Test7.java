package com.bf;

/**
 * @description:
 * @author: bofei
 * @date: 2020-11-17 16:24
 **/
public class Test7 {
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        long a = 0;
        for (int i = 0; i < 100000000; i++) {
            a += i;
        }
        System.out.println(a);
        System.out.println((System.currentTimeMillis() - l));
    }
}
