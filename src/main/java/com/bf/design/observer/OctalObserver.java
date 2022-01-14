package com.bf.design.observer;

/**
 * @description:
 * @author: bofei
 * @date: 2021-04-22 11:47
 **/
public class OctalObserver extends Observer{

    public OctalObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Octal String: "
                + Integer.toOctalString( subject.getState() ) );
    }
}