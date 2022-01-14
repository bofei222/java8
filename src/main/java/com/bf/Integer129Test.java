package com.bf;

/**
 * @description:
 * @author: bofei
 * @date: 2021-04-21 10:43
 **/
public class Integer129Test {
    public static void main(String[] args) {
        Integer integer = new Integer(129);
        Integer integer2 = new Integer(129);
        System.out.println(integer == integer2);



        Integer integer9 = new Integer(127);
        Integer integer8 = new Integer(127);
        System.out.println(integer9 == integer8);


        Integer integer19 = 127;
        Integer integer18 = 127;
        System.out.println(integer19 == integer18);

        Integer integer29 = 129;
        Integer integer28 = 129;
        System.out.println(integer29 == integer28);
    }
}
