package com.bf.container.list;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: bofei
 * @date: 2020-08-10 22:16
 **/
public class Test06 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Object> list = new ArrayList<>(4);
        Field elementData = list.getClass().getDeclaredField("elementData");
        elementData.setAccessible(true);
        Object[] objects = (Object[]) elementData.get(list);
        System.out.println(objects.length);

        ArrayList<Object> newList = list;
        for (int i = 0; i < 100; i++) {
            newList.add(i);
        }

        System.out.println(newList.equals(list));;

    }
}
