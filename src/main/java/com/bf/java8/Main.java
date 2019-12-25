package com.bf.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: bofei
 * @date: 2019-11-22 10:30
 **/
public class Main {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 5, 4, 3);
        list.sort(Integer::compareTo);
//        System.out.println(list);
        list.sort((a, b) -> b - a);
        list.sort(Comparator.comparingInt(a -> a));
//        System.out.println(list);

        MathOperation add = (a, b) -> a + b + 1;
        MathOperation sub = (a, b) -> a - b + 1;
        MathOperation sum2 = (a, b) -> a - b + 2;

        int b = operate(add, 1, 2);// 4
        int a = operate(sub, 1, 2);// 0
        System.out.println(a);
        System.out.println(b);
//        operate((a, b) -> a - b + 2 , 1, 2);


        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        List<Integer> squareNums = nums.stream().
                map(n -> n * n).
                collect(Collectors.toList());
        System.out.println(squareNums);

    }

    public static int operate(MathOperation s, Integer a, Integer b) {
        return s.operation(a, b);
    }



}

interface MathOperation {
    int operation(int a, int b);
//    int operation2(int a, int b,int c); // 有 两个方法会报错

}


