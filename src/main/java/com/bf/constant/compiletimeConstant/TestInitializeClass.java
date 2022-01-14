package com.bf.constant.compiletimeConstant;

class InitalizedClass {
    static {
        System.out.println("You have initalized InitalizedClass!");
    }
    //和上面的例子唯一的差异就是此处的变量INITIALIZED_VARIBLE被声明为final
    public final static int INITIALIZED_VARIBLE = 1;

}

public class TestInitializeClass {
    public static void main(String[] args) {
        System.out.println(InitalizedClass.INITIALIZED_VARIBLE);
    }
    /**
     * 输出结果为：
     * 1
     * INITIALIZED_VARIBLE为编译期常量，它不会导致类的初始化。
     */
}
