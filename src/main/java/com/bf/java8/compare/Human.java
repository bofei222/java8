package com.bf.java8.compare;

import lombok.Data;

/**
 * @description:
 * @author: bofei
 * @date: 2020-07-02 16:51
 **/
@Data
public class Human {
    private String name;
    private int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
