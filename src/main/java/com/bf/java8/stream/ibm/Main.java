package com.bf.java8.stream.ibm;

import java.util.stream.Stream;

/**
 * @description:
 * @author: bofei
 * @date: 2024-07-04 21:57
 **/
public class Main {

    public static void main(String[] args) {
        Stream.of(1 * 5, 1 * 10)
                .forEach(System.out::println);

        Stream.of(1, 2, 3)
                .map(v -> v + 1) // 2 3 4
                .flatMap(v -> Stream.of(v * 5, v * 10)) // 10 20 15 30 20 40
                .forEach(System.out::println);
                //输出 10，20，15，30，20，40


    }
}
