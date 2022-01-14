package com.bf.container.iterator;

import java.util.*;

public class Test01 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("--------------");
        for (Iterator iterator2 = list.iterator(); iterator2.hasNext();) {
            String next = (String) iterator2.next();
            System.out.println(next);
        }
        System.out.println("set-------------------------");
        Set set = new HashSet();
        set.add("aaa");
        set.add("bbb");
        set.add("ccc");

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            String next = (String) iterator.next();
            System.out.println(next);
        }
        System.out.println("---------------------");
        for (Iterator iterator2 = set.iterator(); iterator2.hasNext();) {
            String next = (String) iterator2.next();
            System.out.println(next);
        }


    }
}
