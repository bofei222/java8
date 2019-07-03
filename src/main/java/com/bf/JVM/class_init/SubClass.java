package com.bf.JVM.class_init;

/**
 * @Author bofei
 * @Date 2019/3/20 10:02
 * @Description
 */
public class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init !");
    }
}
