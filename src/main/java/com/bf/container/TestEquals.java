package com.bf.container;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestEquals {
    public static void main(String[] args) {
        List list = new ArrayList();
        String s1 = new String("aaa");
        String s2 = new String("aaa");
        list.add(s1);
        list.add(s2);
        System.out.println(list.size());
        // 判断重不重复 依赖于equals
        Map map = new HashMap();
        map.put(s1, "AAA");
        map.put(s2, "BBB");
        System.out.println(map.get("aaa"));
    }
}
