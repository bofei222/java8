package com.bf.java8.mkyong;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: bofei
 * @date: 2020-02-21 17:18
 **/
public class TestListMap {

    public static void main(String[] args) {

        List<Hosting> list = new ArrayList<>();
        list.add(new Hosting(1, "liquidweb.com", 80000));
        list.add(new Hosting(2, "linode.com", 90000));
        list.add(new Hosting(3, "digitalocean.com", 120000));
        list.add(new Hosting(4, "aws.amazon.com", 200000));
        list.add(new Hosting(5, "mkyong.com1", 1));
        list.add(new Hosting(5, "mkyong.com2", 2));

        // key = id, value - websites
        Map<Integer, String> result1 = list.stream().collect(
                Collectors.toMap(Hosting::getId, Hosting::getName, (v1,v2) -> v1+","+v2));

        System.out.println("Result 1 : " + result1);

        // key = name, value - websites
        Map<String, Long> result2 = list.stream().collect(
                Collectors.toMap(Hosting::getName, Hosting::getWebsites));

        System.out.println("Result 2 : " + result2);

        // Same with result1, just different syntax
        // key = id, value = name
        Map<Integer, String> result3 = list.stream().collect(
                Collectors.toMap(x -> x.getId(), x -> x.getName()));

        System.out.println("Result 3 : " + result3);

        //
        Map<Integer, Hosting> result4 = list.stream().collect(
                Collectors.toMap(x -> x.getId(), x -> x));

        System.out.println("Result 4 : " + result4);
    }
}