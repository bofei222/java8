package com.bf.stringdemo;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @description:
 * @author: bofei
 * @date: 2019-09-04 10:17
 **/
public class StringFormatDemo {
    public static void main(String[] args) {
//        String s = String.format("%.4f", "100");
//        System.out.println(s);

        BigDecimal bigDecimal = new BigDecimal("100").setScale(4, RoundingMode.HALF_UP);
        System.out.println(bigDecimal);
    }
}
