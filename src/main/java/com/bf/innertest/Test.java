package com.bf.innertest;

import com.bf.inner.Outter;

/**
 * @description:
 * @author: bofei
 * @date: 2019-10-09 15:29
 **/
public class Test {
    public static void main(String[] args) {
        Outter.Inner1 inner1 = new Outter().new Inner1();
    }
}
