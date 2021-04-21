package com.bf;

/**
 * @description:
 * @author: bofei
 * @date: 2020-11-19 11:44
 **/
public class Test09 {
    public static void main(String[] args) {
        int a = 1;
        int b = a;
        System.out.println(b);
        b = 3;
        System.out.println(a);


    }
    public static void main2(String[] args) {
//        int a = 3; // ha
        int a = 1; // 1 2 hah
        switch (a) {
            case 1:
                System.out.println(1);
//                break;
            case 2:
                System.out.println(2);
//                break;
            default:
                System.out.println("hha");
        }
    }
}
