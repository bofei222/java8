package com.bf.primite;

/**
 * @description:
 * @author: bofei
 * @date: 2021-02-03 20:21
 **/
public class Long2Double {
    public static void main(String[] args) {
        long number = 499999999000000001L;
        double converted = (double) number;
        System.out.println(number - (long) converted);
    }
}
