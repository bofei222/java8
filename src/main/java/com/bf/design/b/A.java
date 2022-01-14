package com.bf.design.b;

/**
 * @description:
 * @author: bofei
 * @date: 2022-01-13 14:48
 **/
public class A implements LInterface {

    public void create() {
        B b = new B(this);
    }
    @Override
    public void xx() {
        System.out.println("A.xx");
    }
}

