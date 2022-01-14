package com.bf.container.mkyong;

import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: bofei
 * @date: 2020-01-16 13:51
 **/
@Data
public class Student {
    private String name;
    private int age;
    private List<String> skills;
}
