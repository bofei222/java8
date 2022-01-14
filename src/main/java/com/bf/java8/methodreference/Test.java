package com.bf.java8.methodreference;

import java.util.Arrays;

/**
 * @Author bofei
 * @Date 2019/7/8 10:28
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        Arrays.asList("Windows", "Mac OSX").forEach(x -> System.out.println(x));
        Arrays.asList("Windows", "Mac OSX").forEach(System.out::println);
    }
}
