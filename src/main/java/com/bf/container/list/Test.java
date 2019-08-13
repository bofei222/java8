package com.bf.container.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: bofei
 * @date: 2019-08-12 19:08
 **/
public class Test {
    public static void main(String[] args) {

        List<String> list1 = new ArrayList<String>();
        list1.add("A");
//        list1.add("B");
//        list1.add("C");

        List<String> list3 = new ArrayList<String>();
        list3.add("A");
        list3.add("B");
        list3.add("C");

        List<String> list2 = new ArrayList<String>();
        list2.add("B");
        list2.add("C");
        list2.add("D");

        list1.removeAll(list2);
        System.out.println(list1);

//        list2.removeAll(list1);
//        System.out.println(list2);



    }
}
