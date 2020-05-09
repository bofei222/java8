package com.bf.container.list.a;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Object> arrayList = new ArrayList<>(16);
        arrayList.add(1);

        System.out.println(arrayList.size()); // 1

        String[] arr = new String[16];
        arr[0] = "a";
        System.out.println(arr.length); // 16 数组则不同
    }
}
