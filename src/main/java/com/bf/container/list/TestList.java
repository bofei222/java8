package com.bf.container.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: bofei
 * @date: 2019-12-25 09:35
 **/
public class TestList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

        // ConcurrentModificationException
//        for (Integer integer : list) {
//            list.remove(integer);
//            list.add(5);
//        }

        // ConcurrentModificationException
//        list.forEach(x -> {
//            list.remove(x);
//            list.add(5);
//        });

        /**
         * 索引i位置变了
         * 移除1
         * 移除3
         * 移除5
         * 移除5
         * [2, 4, 5, 5]
         * @date 2019/12/25 9:43
         */
        for (int i = 0; i < list.size(); i++) {
            Integer x = list.get(i);
            System.out.println("移除" + x);
            list.remove(x);
            list.add(5);
        }
        System.out.println(list);
    }
}
