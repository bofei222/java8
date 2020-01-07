package com.bf.java8.v2ex.rizon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

/**
 * @description:
 * @author: bofei
 * @date: 2019-12-31 13:44
 **/
public class Test {
    public static void main(String[] args) {

        String s = Arrays.asList(new Person(1, "bofei"),
                new Person(2, "bofei"),
                new Person(3, "notExist")
        )
                .stream()
                .map(Person::getName)
                .filter("notExist"::equals)
                .findAny()
                .orElse("default");
        System.out.println(s);


    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Person {
    private Integer id;
    private String name;
}