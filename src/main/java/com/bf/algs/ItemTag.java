package com.bf.algs;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 类似于 双向链表的形式 , 把 前一个节点和 后一个节点， 替换为 n个后一个节点
 */
@Data
public class ItemTag {
    private String itemTagCode;
    private String itemTagName;

    List<ItemTag> itemTagList;

    public static void main(String[] args) {
        ItemTag a = new ItemTag();
        a.setItemTagName("001");
        a.setItemTagCode("a");

        List<ItemTag> list = new ArrayList<>();

        ItemTag b = new ItemTag();
        b.setItemTagName("002");
        b.setItemTagCode("b");

        ItemTag c = new ItemTag();
        c.setItemTagName("003");
        c.setItemTagCode("c");

        list.add(b);
        list.add(c);

        a.setItemTagList(list);
        System.out.println(a);
    }
}
