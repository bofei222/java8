package com.bf.container.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test02 {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("id", 0301);
        map.put("name", "saber");
        map.put("salary", 3000);
        map.put("department", "项目部");
        map.put("hireDate", "2017-02");
        Map map2 = new HashMap();
        map2.put("id", 0301);
        map2.put("name", "远坂凛");
        map2.put("salary", 3000);
        map2.put("department", "项目部");
        map2.put("hireDate", "2017-02");
        Map map3 = new HashMap();
        map3.put("id", 0301);
        map3.put("name", "艾瑞莉娅");
        map3.put("salary", 3000);
        map3.put("department", "项目部");
        map3.put("hireDate", "2017-02");

        List<Map> eList = new ArrayList<>();
        eList.add(map);
        eList.add(map2);
        eList.add(map3);
        printAllName(eList);
    }

    public static void printAllName(List<Map> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).get("name") + "--" +list.get(i).get("salary"));
        }
    }
}
