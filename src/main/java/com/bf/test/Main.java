package com.bf.test;

import org.junit.Test;

/**
 * @description:
 * @author: bofei
 * @date: 2022-12-06 17:11
 **/
public class Main {

    @Test
    public void main() {

        TestBookCallBack testBookCallBack = new TestBookCallBack();
        testBookCallBack.test(new CallBack() {
            @Override
            public void execute() {
                System.out.println("-------------------Anonymous Inner Class-------------------");
            }
        });
    }


}