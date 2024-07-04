package com.bf.test;

/**
 * @description:
 * @author: bofei
 * @date: 2023-03-30 09:58
 **/
public class ByteTest {

    public static void main(String[] args) {
        int i = 200;
        byte b = (byte) 200;
        System.out.println(b);
        System.out.println(b & 0xFF); // "200"

        byte b2 = 127;
        System.out.println(b2);

    }
}
