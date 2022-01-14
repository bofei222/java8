package com.bf.container.map.stackoverflow;

import java.util.Collections;
import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Object> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(4);
        linkedList.add(2, 3);
        System.out.println(linkedList);
    }
}
