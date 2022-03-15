package com.bf.container.iterator;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * @description:
 * @author: bofei
 * @date: 2022-02-09 14:21
 **/
public class Test03 {
    public static void main(String[] args) {
          ArrayList<String> array = new ArrayList<>();

//        Person p1 = new Person("Tom1");
//        Person p2 = new Person("Tom2");
//        Person p3 = new Person("Tom3");
//        Person p4 = new Person("Tom4");

        array.add("p1");
        array.add("p2");
        array.add("p3");
        array.add("p4");

        for (ListIterator<String> i = array.listIterator(); i.hasNext();) {
            String next = i.next();
            i.set("x" + next);
        }
        System.out.println(array);

        new Thread(() -> System.out.println(11));
    }
}
