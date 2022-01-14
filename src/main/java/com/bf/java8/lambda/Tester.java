package com.bf.java8.lambda;

import java.util.stream.Stream;

/**
 * @description:
 * @author: bofei
 * @date: 2020-02-21 16:28
 **/
public class Tester {

    public static void main(String[] args) {
        Stream.of(1,2,3,4,5,6,7,8,9).filter(item -> {
            System.out.println("filter");
            return item > 2;
        }).findFirst();
    }
}
