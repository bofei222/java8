package com.bf.java8.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author bofei
 * @Date 2019/7/8 9:49
 * @Description
 */
public class MapTest {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        List<Integer> squareNums = nums.stream().
                map(n -> n * n).
                collect(Collectors.toList());
        System.out.println(squareNums);
    }

    @Test
    public void test1() {
        List<String> wordList = Arrays.asList("a", "b", "c");
        List<String> output = wordList.stream().
//                map(String::toUpperCase).
        map(w -> w.toUpperCase()).
                collect(Collectors.toList());
        System.out.println(output);
    }
}
