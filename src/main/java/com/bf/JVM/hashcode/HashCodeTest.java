package com.bf.JVM.hashcode;

/**
 * @Author bofei
 * @Date 2019/4/8 17:52
 * @Description
 */

public class HashCodeTest {
    public static void main(String[] args) {
        String s = "ok";
        StringBuilder sb = new StringBuilder(s);
        String[] arr1 = {"a","b"};
        String[] arr2 = {"a","b"};
        System.out.println(arr1 == arr2);
        System.out.println(arr1.equals(arr2));

        System.out.println(s.hashCode() + "  " + sb.hashCode());

        String t = new String("ok");
        StringBuilder tb = new StringBuilder(s);
        System.out.println(t.hashCode() + "  " + tb.hashCode());

        System.out.println(s.equals(t));
        System.out.println(sb.toString().equals(tb.toString()));
        System.out.println(s.equals(sb));

        System.out.println(s == t);
        System.out.println(sb == tb);
//        System.out.println(s == sb); 类型不同  不能用 == 比较
    }

}

