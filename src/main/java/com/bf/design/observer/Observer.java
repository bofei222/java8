package com.bf.design.observer;



/**
 * @description:
 * @author: bofei
 * @date: 2021-04-22 11:41
 **/
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}