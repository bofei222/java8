package com.bf.design.a;

/**
 * @description:
 * @author: bofei
 * @date: 2020-01-07 19:08
 **/
public abstract class ChinaPay implements Pay{
    @Override
    public void pay() {
        prePay();
        paying();
        afterPay();
    }
    abstract void prePay();
    abstract void paying();
    abstract void afterPay();


}
