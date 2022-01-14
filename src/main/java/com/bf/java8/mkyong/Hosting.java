package com.bf.java8.mkyong;

import lombok.Data;

/**
 * @description:
 * @author: bofei
 * @date: 2020-02-21 17:17
 **/
@Data
public class Hosting {

    private int Id;
    private String name;
    private long websites;

    public Hosting(int id, String name, long websites) {
        Id = id;
        this.name = name;
        this.websites = websites;
    }
}
