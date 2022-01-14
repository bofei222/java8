package com.bf.container.map.a;

import org.checkerframework.checker.units.qual.K;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @description:
 * @author: bofei
 * @date: 2020-04-21 13:20
 **/
public class HashMapDemo {
    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException, InvocationTargetException, IllegalAccessException {
        HashMap<String, String> map = new HashMap<String, String>(3);
//    1:    capacity0 : 1
//        threshold1 : 1
//  3:      capacity0 : 4
//        threshold1 : 4

//        map.put("1", "a");
        Class<?> mapType = map.getClass();
        Method capacity = mapType.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        System.out.println("capacity0 : " + capacity.invoke(map));

        Field threshold1 = mapType.getDeclaredField("threshold");
        threshold1.setAccessible(true);
        Object o = threshold1.get(map);
        System.out.println("threshold1 : " + o.toString());


        Field size = mapType.getDeclaredField("size");
        size.setAccessible(true);
        System.out.println("size0 : " + size.get(map));

        System.out.println("put------------------------");

        String put1 = map.put("hollis", "hollischuang");
        System.out.println("put1 : " + put1);
        System.out.println("capacity : " + capacity.invoke(map));
        String put2 = map.put("hollis", "hollischuang");
        System.out.println("put2 : " + put2);
        String put3 = map.put("hollis3", "hollischuang");
        System.out.println("put3 : " + put3);

        Field size1 = mapType.getDeclaredField("size");
        size1.setAccessible(true);
        System.out.println("size1 : " + size1.get(map));


    }




}
