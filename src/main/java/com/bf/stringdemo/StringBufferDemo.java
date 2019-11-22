package com.bf.stringdemo;

/**
 * @description:
 * @author: bofei
 * @date: 2019-11-12 16:58
 **/
public class StringBufferDemo {
    public static void main(String[] args) {
        String test = test("a", "b", "c");
        System.out.println(test);
    }
    public static String test(String... string) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < string.length; i++) {
            String s = string[i];
            if (i != string.length - 1) {
                sb.append(s);
                sb.append("-");
            } else {
                sb.append(s);
            }
        }
        return sb.toString();
    }
}

