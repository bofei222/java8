package com.bf.generics;

import java.util.ArrayList;
import java.util.List;

public class Test01<T,Q> {
    private T t;
    private final int age;

    public Test01() {
        age = 0;
    }

    public static A getT(A a) {
        return a;
    }

    public static <M> void add(M m) {
        System.out.println("Test01.add");
    }

    private static class A<T>{

    }

    public static <K,V> void test(K k, V v) {
        System.out.println(k);
    }


    public static void main(String[] args) {
//        List list = new ArrayList<int>();
        List list2 = new ArrayList<Integer>();
        test("a", "b");



    }
}
