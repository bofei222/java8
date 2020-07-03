package com.bf.java8.compare;

import lombok.Data;

/**
 * @description:
 * @author: bofei
 * @date: 2020-07-02 16:51
 **/
@Data
public class Human {
    String name;
    int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 与 Comparator 接口的 compare方法 有完全相同的签名
    public static int compareByNameThenAge(Human lhs, Human rhs) {
        if (lhs.name.equals(rhs.name)) {
            return lhs.age - rhs.age;
        } else {
            return lhs.name.compareTo(rhs.name);
        }
    }
}
