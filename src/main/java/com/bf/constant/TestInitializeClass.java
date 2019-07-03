package com.bf.constant;

class InitalizedClass {
    static {
        System.out.println("You have initalized InitalizedClass!");
    }
    public static int inititalize_varible = 1;

}

public class TestInitializeClass {

    public static void main(String[] args) {
        System.out.println(InitalizedClass.inititalize_varible);
    }
    /**
     * 输出结果为：
     * You have initalized InitalizedClass!
     * 1
     */

}
