package com.bf.java8.stream;

import org.junit.Test;

import java.util.stream.Stream;

/**
 * @description:
 * @author: bofei
 * @date: 2021-11-21 11:02
 **/
public class StreamDemo {

    @Test
    public void testFlatMap() {
        Stream.of(1, 2, 3)
                .map(v -> v + 1) //2 3 4
                .flatMap(v -> Stream.of(v * 5, v * 10))
                .forEach(System.out::println);
        // 输出 10，20，15，30，20，40
    }
}
