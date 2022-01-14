package com.bf.container.map.a;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: bofei
 * @date: 2020-01-03 20:15
 **/
public class MapTest {
    public static void main(String[] args) {
        // 并发修改异常
        Map map = new HashMap<>(); // Exception in thread "main" java.util.ConcurrentModificationException
//        Map map = new ConcurrentHashMap();
        map.put(1, "a");
        map.put(2, "b");
        Set keySet = map.keySet();
        for (Object key : keySet) {
            System.out.println(key);
            map.put(3, "c");
        }

    }
}
