package com.bf.design.observer;

/**
 * @description:
 * @author: bofei
 * @date: 2021-04-22 11:43
 **/
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binary String: "
                + Integer.toBinaryString(subject.getState()));
    }
}