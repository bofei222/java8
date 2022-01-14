package com.bf.JVM.hashcode;

/**
 * @Author bofei
 * @Date 2019/1/22 19:21
 * @Description
 */
public class TestInteger {

    public int a = 129;
    public static int c = 129;

    public void test() {
        int b = 129;
    }

    public static void main(String[] args) {

        Integer i1 = 100, i2 = 100, i3 = 150, i4 = 150;
        int i5 = 150, i6 = 150;
        new Object().equals(new Object());

        Integer.valueOf(100);
        System.out.println(i1 == i2);//Integer 值范围在-128~127时，存放在运行时常量池中，超过范围存放在堆中。
        System.out.println(i3 == i4);// 所以i3、i4的值没有直接保存在运行时常量池中，而是新newInteger对象。
        System.out.println(i5 == i6);// 基本类型存储在栈中 基本类型 == 比较的是值
        System.out.println("------------------------------------");

        String s1 = "a", s2 = "a", s3 = new String("a"), s4 = new String("a");
        System.out.println(s1 == s2);
        System.out.println("eq: " + s1.equals(s3));
        System.out.println("eq: " + s3.equals(s4));
        System.out.println(s1 == s3);
        System.out.println(s3 == s4);
        System.out.println("------------------------------------");

        Float f1 = 1f, f2 = 1f;
        Float.valueOf(1);
        System.out.println("Float " + (f1 == f2));
        double d = 1.0d;
        float f = 120.0f;
        float f3 = 120.0f;
        System.out.println("float " + (f == f3));
        System.out.println("------------------------------------");

        Long.valueOf(1);
        Character.valueOf('c');
        short s = 1;
        Short.valueOf(s);
        byte b = 0xa;
        System.out.println(b);
        Byte.valueOf(b);


        Integer a = 150;
        change(a);
        System.out.println(a);
    }

    public static void change(Integer x) {
        x = 151;
    }
}
