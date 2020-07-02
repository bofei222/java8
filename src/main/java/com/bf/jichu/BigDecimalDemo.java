package com.bf.jichu;

import java.math.BigDecimal;

/**
 * @description: 不可见字符
 * @author: bofei
 * @date: 2020-07-02 11:18
 **/
public class BigDecimalDemo {
    public static void main(String[] args) {
        String trim = "150.3210\u202C".trim();
        String replace = trim.replace("\u202C", "");
        BigDecimal bigDecimal = new BigDecimal(replace);
//        BigDecimal bigDecimal = new BigDecimal("150.3210");
        System.out.println(bigDecimal);
    }
}
