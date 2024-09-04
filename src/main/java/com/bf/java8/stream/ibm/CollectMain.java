package com.bf.java8.stream.ibm;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description:
 * @author: bofei
 * @date: 2024-07-04 22:03
 **/
public class CollectMain {
    public static void main(String[] args) {

        final Map<Character, List<String>> names = Stream.of("Alex", "Bob", "David", "Amy")
                .collect(Collectors.groupingBy(v -> v.charAt(0)));
        System.out.println(names);
    }
}
