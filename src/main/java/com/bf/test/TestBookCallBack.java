package com.bf.test;

/**
 * @description:
 * @author: bofei
 * @date: 2022-12-06 17:11
 **/
public class TestBookCallBack {
    public void test(CallBack callBack) {

        //1.处理业务
        System.out.println("---------业务处理类 TestBookCallBack---------");
        //2.执行回调函数
        callBack.execute();

    }
}
