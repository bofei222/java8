package com.bf.test;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: bofei
 * @date: 2020-07-15 20:16
 **/
public class Main {

    public static void main(String[] args) {
        char c = '5'; //53
        char d = '4'; //52
        System.out.println(c + d); // 105
        System.out.println(c - d);

        char a = '5'; //53
        char b = '4'; //52
        // 此处 -'0'和下边+'0'，是使用ASCII码表中数字相加减原理，免去类型转换
        System.out.println(a - '0' + b - '0'); // 9
        System.out.println(a - b);
    }

    public static void main3(String[] args) {
        String s1 = "123456789012345";
        String s2 = "123456789012345";
        System.out.println(new BigDecimal(s1).add(new BigDecimal(s2)));
    }

    // 实现并返回，2个长整数的字符串相加的和，比如”1234567890” + “99” = “1234567989”，
    // 可以使用整型类型，
    // // 但不能直接转成Integer、Long等整型
    public static void main2(String[] args) {
        String s1 = "123456789012345";
        String s2 = "123456789012345";

        int max = Math.min(s1.length(), s2.length());


        char[] chars = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        List<Integer> arrayList = new ArrayList<>();
        List<String> resultList = new ArrayList<>();

        int b = 0;

        for (int i = chars.length - 1; i >= 0; i--) {

            int result = Integer.parseInt(String.valueOf(chars[i])) + Integer.parseInt(String.valueOf(chars2[i]));

            int a = result % 10;

            if (b != 0) {
                a += b;
            }
            arrayList.add(a);
            resultList.add(String.valueOf(a));

            b = result / 10;  // 将b 加在 下一次 循环的a上
        }

        System.out.println(arrayList);
        Collections.reverse(resultList);

        String join = String.join("", resultList);
        System.out.println(join);
        //246,913,578,024,690
        //246,913,578,024,690
//        chars

       /* Integer i1 = Integer.valueOf(s1);
        Integer i2 = Integer.valueOf(s2);
        System.out.println(i1 + i2);*/
    }
}
