package com.bf.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: bofei
 * @date: 2019-08-12 15:03
 **/
public class Ht {
    String ele;
    String price;

    @Override
    public String toString() {
        return "Ht{" +
                "ele='" + ele + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public String getEle() {
        return ele;
    }

    public void setEle(String ele) {
        this.ele = ele;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    public static void main(String[] args) {
        Ht h = new Ht();
        h.setEle("ele");
        h.setPrice("price");
        test2(h, "com.bf.reflection.Ht");


        Ht2 ht2 = new Ht2();
        ht2.setXx_ele("ele_xx");
        ht2.setXx_price("price_xx");
        test2(ht2, "com.bf.reflection.Ht2");
        System.out.println(ht2);
    }

    public static void test2(Object o, String aaa) {
        Class<?> aClass = null;
        try {
            aClass = Class.forName(aaa);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Field[] f = aClass.getDeclaredFields();

        for (int i = 0; i < f.length; i++) {
            try {
                String attributeName = f[i].getName();
                String methodName = attributeName.substring(0, 1).toUpperCase() + attributeName.substring(1);
                Method getMethod = aClass.getMethod("get" + methodName);

                Method setMethod = aClass.getMethod("set" + methodName, String.class);
                Object result;

                try {
                    result = getMethod.invoke(o);

                    if (attributeName.contains("ele")) {
                        setMethod.invoke(o, result + "*10");
                    }
                    if (attributeName.contains("price")) {
                        setMethod.invoke(o, result + "/10");
                    }
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }


    }

    @org.junit.Test
    public void test() {
        Ht h = new Ht();
        h.setEle("ele");
        h.setPrice("price");


        Field[] f = Ht.class.getDeclaredFields();

        for (int i = 0; i < f.length; i++) {
            try {
                String attributeName = f[i].getName();
                String methodName = attributeName.substring(0, 1).toUpperCase() + attributeName.substring(1);
                Method getMethod = Ht.class.getMethod("get" + methodName);

                Method setMethod = Ht.class.getMethod("set" + methodName, String.class);
                Object result;

                try {
                    result = getMethod.invoke(h);

                    if (attributeName.contains("ele")) {
                        setMethod.invoke(h, result + "*10");
                    }
                    if (attributeName.contains("price")) {
                        setMethod.invoke(h, result + "/10");
                    }
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        System.out.println(h);

    }
}


class Ht2 {
    String xx_ele;
    String xx_price;

    public String getXx_ele() {
        return xx_ele;
    }

    public void setXx_ele(String xx_ele) {
        this.xx_ele = xx_ele;
    }

    @Override
    public String toString() {
        return "Ht2{" +
                "xx_ele='" + xx_ele + '\'' +
                ", xx_price='" + xx_price + '\'' +
                '}';
    }

    public String getXx_price() {
        return xx_price;
    }

    public void setXx_price(String xx_price) {
        this.xx_price = xx_price;
    }
}