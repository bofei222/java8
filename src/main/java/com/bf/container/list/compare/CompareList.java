package com.bf.container.list.compare;

/**
 * @description:
 * @author: bofei
 * @date: 2021-06-21 16:17
 **/
public class CompareList {
    public static void main(String[] args) {
        new A(1, 10, "a");
        new A(2, 10, "b");
        new A(3, 10, "c");
    }
}

class A {

    int id;
    int age;
    String name;

    public A(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }
}
