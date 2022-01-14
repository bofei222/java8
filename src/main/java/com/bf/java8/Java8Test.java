package com.bf.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author bofei
 * @date 2018/6/20 15:54
 */
public class Java8Test {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Predicate<Integer> predicate = n -> true;
        System.out.println("输出所有数据");
        eval(list, n -> true);

        System.out.println("输出所有偶数");
        eval(list, n -> {
            return n%2 == 0;
        });

        System.out.println("输出大于3的数");
        eval(list, n -> n >3);

        System.out.println("输出大于3的数");
        list.stream().filter(n -> n >3).forEach(n -> System.out.println(n));
        System.out.println("输所有数据");
        list.stream().forEach(System.out::print);
    }


    public static void eval(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer n : list) {
            if (predicate.test(n)) {
                System.out.println(n + " ");
            }
        }
    }

}
