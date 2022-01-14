package com.bf.JVM.valueorref;

/**
 * @description:
 * @author: bofei
 * @date: 2020-06-09 18:22
 **/
public class ValueTransfDemo {
    public static void main(String[] args) {


        int q2= 128;
        int w2= 200;
        System.out.println("q2==w2" + (q2==w2)); // 基本类型 不管是多少 返回都是true的
        Integer q1 = 128; // 用int给Integer赋值的那条语句 就是一个自动装箱的过程 相当于：
        Integer c = Integer.valueOf(200);
        Integer w1 = 128;
        System.out.println("q1==w1 " + (q1 ==w1)); //127 true //128 false

        Integer q3 = 127;
        Integer w3 = 127;
        w3.intValue();// 自动拆箱
        System.out.println("q3==w3 " + (q3 ==w3)); //127 true //128 false

        System.out.println();
        Integer q = new Integer(123);
        Integer w = new Integer(123);
        System.out.println("q == w " + (q == w));
        System.out.println(q.equals(w));

        System.out.println("q2==w1 " + (q2==w1));

        int i = 123321;
        int j = 123321;
        System.out.println(i == j);
        System.out.println();

        int xx = i;
        System.out.println("xx == i " + (xx == i));
        i--;
        System.out.println("xx " + xx);
        System.out.println("xx == i " + (xx == i));

        System.out.println();
        System.out.println("array=============");
        String[] a = {"a", "b", "c"};
        String[] b = {"a", "b", "c"};
        System.out.println(a.equals(b)); // == 比较引用的值 -> 比较内存的物理地址


        System.out.println("String==================");
        String abc = new String("abv");
        String abc2 = new String("abv");
        System.out.println(abc == abc2);
        System.out.println(abc.equals(abc2));

        System.out.println("String常量池==================");
        String abd = "abd";
        String abd2 = "abd";
        System.out.println(abd == abd2);
    }
}
