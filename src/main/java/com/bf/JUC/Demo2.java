package com.bf.JUC;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @description:
 * @author: bofei
 * @date: 2020-06-05 10:03
 **/
public class Demo2 {
    public static void main(String[] args) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("a", 1);
        List<LinkedHashMap> list = new ArrayList<>();
        list.sort(Comparator.comparing(e -> e.get("a").toString(), String.CASE_INSENSITIVE_ORDER));
        list.sort(Comparator.comparing(e -> e.get("a").toString()));



    }
}
