package com.bf.design.b;

/**
 * @description:
 * @author: bofei
 * @date: 2022-01-13 14:50
 **/
public class B {
    public LInterface l;

    public B(LInterface l) {
        this.l = l;
    }

    public void xx() {
        l.xx();
    }
}
