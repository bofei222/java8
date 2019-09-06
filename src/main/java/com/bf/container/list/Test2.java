package com.bf.container.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 集合转数组
 * @author: bofei
 * @date: 2019-09-06 10:36
 **/
public class Test2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("a");
        list.add("b");
        list.add("c");

        String[] arr = new String[3];
        String[] newArr = list.toArray(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(newArr));
        System.out.println(arr == newArr);




        System.out.println("-------------------");
        String[] arr2 = new String[2];
        String[] newArr2 = list.toArray(arr2);
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(newArr2));


    }
}
