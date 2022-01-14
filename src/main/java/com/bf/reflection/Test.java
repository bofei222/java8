package com.bf.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: bofei
 * @date: 2019-08-08 18:13
 **/
public class Test {

    @Override
    public String toString() {
        return "Test{" +
                "aa='" + aa + '\'' +
                ", bb=" + bb +
                ", cc='" + cc + '\'' +
                ", dd='" + dd + '\'' +
                '}';
    }

    public String aa;

    public int bb;

    public String cc;

    public String dd;

    public String getAa() {
        return aa;
    }

    public void setAa(String aa) {
        this.aa = aa;
    }

    public int getBb() {
        return bb;
    }

    public void setBb(int bb) {
        this.bb = bb;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }


    public static void main(String[] args) throws Exception {

        /**
         *  返回Class 对象所表示的类或接口的所有可访问公共字段。
         */
        Field[] f1 = Test.class.getFields();
        System.out.println("Test类里面的公共字段属性的个数为：" + f1.length + "个，分别为：");
        for (int i = 0; i < f1.length; i++) {
            String attributeName = f1[i].getName();
            System.out.println(attributeName);
        }

        /**
         * 返回 Class 对象所表示的类或接口所声明的所有字段，
         * 包括公共、保护、默认（包）访问和私有字段，但不包括继承的字段。
         */
        Field[] f = Test.class.getDeclaredFields();
        System.out.println("Test类里面的所有字段属性的个数为：" + f.length + "个，分别为：");
        for (int i = 0; i < f.length; i++) {
            String attributeName = f[i].getName();
            System.out.println(attributeName);
        }

        Test test = new Test();
        //给test对象赋值
        for (int i = 0; i < f.length; i++) {
            //获取属相名
            String attributeName = f[i].getName();
            //将属性名的首字母变为大写，为执行set/get方法做准备
            String methodName = attributeName.substring(0, 1).toUpperCase() + attributeName.substring(1);
            try {
                //获取Test类当前属性的setXXX方法（私有和公有方法）
                /*Method setMethod=Test.class.getDeclaredMethod("set"+methodName);*/
                //获取Test类当前属性的setXXX方法（只能获取公有方法）
                Method setMethod = Test.class.getMethod("set" + methodName, String.class);
                //执行该set方法
                setMethod.invoke(test, attributeName + "方法赋值");
            } catch (NoSuchMethodException e) {
                try {
                    Method setMethod = Test.class.getMethod("set" + methodName, int.class);
                    setMethod.invoke(test, 123);
                } catch (Exception e2) {
                    f[i].set(test, attributeName + "直接赋值");
                }

            }

        }

//        System.out.println(test);
        //从test对象取值
        for (int i = 0; i < f.length; i++) {
            //获取属相名
            String attributeName = f[i].getName();
            //将属性名的首字母变为大写，为执行set/get方法做准备
            String methodName = attributeName.substring(0, 1).toUpperCase() + attributeName.substring(1);
            Object result;
            try {
                //获取Test类当前属性的setXXX方法（私有和公有方法）
                /*Method setMethod=Test.class.getDeclaredMethod("set"+methodName);*/
                //获取Test类当前属性的setXXX方法（只能获取公有方法）
                Method getMethod = Test.class.getMethod("get" + methodName);
                //执行该set方法
                result = getMethod.invoke(test);

            } catch (NoSuchMethodException e) {
                result = f[i].get(test);
            }
            System.out.println("属性：" + attributeName + "=" + result);
        }

    }



}

