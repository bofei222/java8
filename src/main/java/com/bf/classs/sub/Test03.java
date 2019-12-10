package com.bf.classs.sub;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: bofei
 * @date: 2019-12-03 19:01
 **/
public class Test03 {
    private String name;
    private List<Character> list;
    private ArrayList<Character> arrayList;

    public static void main2(String[] args) {
        // TODO Auto-generated method stub
        try {
            Field listField = Test03.class.getDeclaredField("arrayList");
            boolean assignableFrom = List.class.isAssignableFrom(listField.getType());
            System.out.println(assignableFrom);
            Class<?> type = listField.getType();

            System.out.println(type);
            Type genericType = listField.getGenericType();
            System.out.println(genericType);
            //获取 list 字段的泛型参数

            ParameterizedType listGenericType = (ParameterizedType) genericType;
            Type[] listActualTypeArguments = listGenericType.getActualTypeArguments();
            System.out.println(listActualTypeArguments[listActualTypeArguments.length - 1]);
            for (int i = 0; i < listActualTypeArguments.length; i++) {
                System.out.println(listActualTypeArguments[i]);
            }
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Test03 test03 = new Test03();
        List<Object> list = new ArrayList<>();
        list.add(test03);
        test03.test(list);
//        test03.test(test03);
    }

    public <T> void test(List<T> list) {
        for (T t : list) {

        }
    }

}

