package com.bf.container.map.b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: bofei
 * @date: 2021-04-07 09:00
 **/
public class Test {
    public static void main(String[] args) {


        String a = new String("a");
        System.out.println("a" == a);

        String b = new String("b");
        Map map = new HashMap<>();
        map.put(1, a);
        map.put(2, b);
        List<Object> list = new ArrayList<>();
        list.add("list");
        map.put(3, list);

        HashMap newMap = new HashMap(map);

        if (map == newMap) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

//        if (map.equals(newMap)) {
//            System.out.println(true);
//        }

        a = "a1";
        System.out.println(a);

        String o1 = (String) map.get(1);
        System.out.println(o1);



    }
}
