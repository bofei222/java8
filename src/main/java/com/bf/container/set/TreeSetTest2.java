package com.bf.container.set;

import java.util.TreeSet;

/**
 * @Author bofei
 * @Date 2019/4/10 18:11
 * @Description
 */
public class TreeSetTest2 {
    public static void main(String[] args) {
        TreeSet<Person> tree = new TreeSet<Person>();
        tree.add(new Person("zhangran"));
        tree.add(new Person("zhang"));
        System.out.println(tree);
    }
}

class Person {
    String name;

    Person(String name) {
        this.name = name;

    }

    public String toString() {
        return this.name;
    }
}