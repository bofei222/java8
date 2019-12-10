package com.bf.algs.d;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 测试ArrayList、LinkedList查找、插入的时间复杂度
 * @author: bofei
 * @date: 2019-12-10 14:01
 **/
public class Test {
    public static void main(String[] args) {
        List<Object> objects = new ArrayList<>();
//        List<Object> objects = new LinkedList<>();
//        objects.get(key)
        objects.add(1);
        objects.add(2);
        objects.add(3);
        System.out.println(objects);
        // 在指定位置 插入元素
        objects.add(1, "x");
        System.out.println(objects);

    }
}
