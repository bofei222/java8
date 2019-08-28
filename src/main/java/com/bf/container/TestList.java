package com.bf.container;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author bofei
 * @Date 2019/6/5 15:59
 * @Description
 */
public class TestList {
    public static void main(String[] args) {
        List list = new ArrayList<>(89);
        list.add("1");

//        System.out.println(list.get(10));
        System.out.println(list.get(0));

        Integer[] arr = new Integer[20];
        System.out.println(arr[2]);
        System.out.println(arr.length);


//        ArrayList<Object> list = new ArrayList<>();
//        int i = 0;
//        while (true) {
//
//            list.add(i++);
//            System.out.println(list.size());
//            list.clear();
//
//        }


    }
}
