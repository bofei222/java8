package com.bf.stringdemo;

import java.math.BigDecimal;

/**
 * @description:
 * @author: bofei
 * @date: 2019-09-04 15:09
 **/
public class MathDemo {
    public static void main(String[] args) {
        String a = "a"; // 参数 非数字 字符
        new BigDecimal(a); // java.lang.NumberFormatException

        String s = null;  // 参数 空
        new BigDecimal(s); // java.lang.NullPointerException


    }
}
