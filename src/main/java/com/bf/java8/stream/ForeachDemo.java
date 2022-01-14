package com.bf.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by bofei on 18-6-20.
 */
public class ForeachDemo {
    public static void main(String[] args) {
        List<String> all = new ArrayList<>();
        all.add("Andriod");
        all.add("Java");
        all.add("Ios");
        all.add("jsp");
        all.add("ORACLE");

//        all.forEach(System.out::println); // foreach只能实现输出
//        Stream<String> stream = all.stream();
//        System.out.println(stream.count());
//        System.out.println("-----------------------");

//        Stream<String> stream1 = all.stream();
//        System.out.println(stream1.distinct().count());
//        System.out.println("----------");
//        System.out.println(all.size());
//        System.out.println("-------");

//        List<String> newAll = all.stream().collect(Collectors.toList());
//        System.out.println(newAll);
//        System.out.println("--------------");

        System.out.println(all.stream().map(x -> x.toLowerCase()).filter(x -> x.contains("a")).collect(Collectors.toList()));
//        System.out.println("-----------");

        // 数据分页
//        System.out.println(all.stream().map(x -> x.toLowerCase()).skip(2).limit(2).collect(Collectors.toList()));

        // 全匹配和部分匹配

        //Map Reduce

    }
}
