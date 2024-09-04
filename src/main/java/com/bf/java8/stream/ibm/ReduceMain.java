package com.bf.java8.stream.ibm;

import java.util.stream.Stream;

/**
 * @description:
 * @author: bofei
 * @date: 2024-07-04 22:00
 **/
public class ReduceMain {
    public static void main(String[] args) {
        Stream.of(1, 2, 3).reduce((v1, v2) -> v1 + v2)
                .ifPresent(System.out::println);
        // 输出 6

        int result1 = Stream.of(1, 2, 3, 4, 5)
                .reduce(1, (v1, v2) -> v1 * v2);
        System.out.println(result1);
        // 输出 120


        // reduce 操作把一个流约简成单个结果。
        int result2 = Stream.of(1, 2, 3, 4, 5)
                .parallel()
                .reduce(0, (v1, v2) -> v1 + v2, (v1, v2) -> v1 + v2);
        System.out.println(result2);
        // 输出 15


    }
}
