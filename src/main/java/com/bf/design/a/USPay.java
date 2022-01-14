package com.bf.design.a;

/**
 * @description:
 * @author: bofei
 * @date: 2020-01-07 19:09
 **/
public abstract class USPay implements Pay{
    @Override
    public void pay() {
        prePay();
        prePay2();
        paying();
        afterPay();
    }
    abstract void prePay();
    abstract void prePay2();
    abstract void paying();
    abstract void afterPay();
}
