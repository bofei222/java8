package com.bf.java8.ibm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: bofei
 * @date: 2019-12-18 14:21
 **/
public class MapDemo {


    // 从上面例子可以看出，map 生成的是个 1:1 映射，每个输入元素，都按照规则转换成为另外一个元素
    public static void main(String[] args) {

        // 转换大写
        List<String> wordList = new ArrayList<>(Arrays.asList("abc", "def", "hG"));
        // map()接受一个Function toUpperCase返回一个String  为什么就好使呢
        // map(String::toUpperCase) == map(x -> x.toUpperCase())
        List<String> output = wordList.stream().
                map(String::toUpperCase).
//                map(x -> x.toUpperCase()).
//                map(x -> {return x.toUpperCase();}).
                collect(Collectors.toList());
        System.out.println(wordList);
        System.out.println(output);

        // 平方数
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        List<Integer> squareNums = nums.stream().
                map(n -> n * n).
                collect(Collectors.toList());
        System.out.println(squareNums);

    }

}
