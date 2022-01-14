package com.bf.design.observer;

/**
 * @description:
 * @author: bofei
 * @date: 2021-04-22 11:47
 **/
public class HexaObserver extends Observer{

    public HexaObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Hex String: "
                + Integer.toHexString( subject.getState() ).toUpperCase() );
    }
}