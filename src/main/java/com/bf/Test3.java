package com.bf;

/**
 * @description:
 * @author: bofei
 * @date: 2020-01-05 15:51
 **/
public class Test3 {
    public static void main(String[] args) {
        test(null);
    }

    public static void test(Integer a ) {

        if (null == a) { // 1
            System.out.println(1);
        }

        //
        if (0 == a) { // java.lang.NullPointerException
            System.out.println(1);
        }
    }
}
