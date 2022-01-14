package com.bf.algs;

import lombok.Data;

/**
 * 链表 的结构 , 包含后一个节点
 */
@Data
public class Tag {
    private String tagCode;
    private String tagName;

    Tag next;


    public static void main(String[] args) {
        Tag a = new Tag();
        a.setTagCode("001");
        a.setTagName("a");

        Tag b = new Tag();
        b.setTagCode("002");
        b.setTagName("b");


        a.setNext(b);

        System.out.println(a);
    }
}
