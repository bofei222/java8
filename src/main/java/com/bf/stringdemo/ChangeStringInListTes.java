package com.bf.stringdemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @description:
 * @author: bofei
 * @date: 2022-02-09 11:08
 **/
public class ChangeStringInListTes {
    public static void main(String[] args) {

        //test1();
        test3();
    }

    public static void test3() {
        List<String> list = new ArrayList<>();
        list.add("5ff");
        list.add("6ff");

        for (String s : list) {
            if (s.equals("5ff")) {
                list.remove(s);
            }
        }


        System.out.println(list);
    }

    public static void test2() {
        List<String> list = new ArrayList<>();
        list.add("5ff");
        list.add("6ff");

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (s.equals("5ff")) {
                list.remove(s);
            }
        }

        System.out.println(list);
    }

    public static void test1() {
        List<String> list = new ArrayList<>();
        list.add("5ff");
        list.add("6ff");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
//            s = s.replaceAll("ff", "");
            if (s.equals("5ff")) {
                iterator.remove();
            }
        }
        System.out.println(list);
    }
}
