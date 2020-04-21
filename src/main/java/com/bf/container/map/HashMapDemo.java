package com.bf.container.map;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: bofei
 * @date: 2020-04-21 13:20
 **/
public class HashMapDemo {
    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException, InvocationTargetException, IllegalAccessException {
        Map<String, String> map = new HashMap<String, String>();


        Class<?> mapType = map.getClass();
        Method capacity = mapType.getDeclaredMethod("capacity");
        capacity.setAccessible(true);


        System.out.println("capacity0 : " + capacity.invoke(map));
        map.put("hollis", "hollischuang");


        System.out.println("capacity : " + capacity.invoke(map));

//        Field aa = mapType.getDeclaredField("capacity");
//        capacity.setAccessible(true);
//        System.out.println("capacity : " + capacity.invoke(map));

        Field size = mapType.getDeclaredField("size");
        size.setAccessible(true);
        System.out.println("size : " + size.get(map));


    }
}
