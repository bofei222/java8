package com.bf.container;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MySet<E> {

    HashMap<E,Object> map;


    private static final Object PRESENT = new Object();

    public MySet() {
        map = new HashMap();
    }

    public void add(E e) {
        map.put(e, PRESENT);
    }

    public int size() {
        return map.size();
    }

    public static void main(String[] args) {
        Set hashSet = new HashSet();
        hashSet.add("aaa");
        hashSet.add("bbb");
        hashSet.add(new String("aaa"));
        System.out.println(hashSet.size());

        MySet mySet = new MySet<String>();
        mySet.add("aaa");
        System.out.println(mySet.size());
    }
}
