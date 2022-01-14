package com.bf.stringdemo;

/**
 * @Author bofei
 * @Date 2019/5/12 16:51
 * @Description
 */
public class StringDemo3 {
    public static void main(String[] args) {
        System.out.println(String.format("%06d",12));


        String s = "a|";
        System.out.println("a|".split("|")[0]);
        System.out.println("a|".split("|")[1]);
        System.out.println("a".split("|")[0]);
    }
}
