package com.bf.test.callBack;

/**
 * @description:
 * @author: bofei
 * @date: 2022-12-06 17:15
 **/
public class CallbackServiceImpl implements CallbackService {
    @Override
    public void callBackFunc() {
        System.out.println("具体实现类回调函数开始执行...");
        System.out.println("具体实现类回调函数结束执行...\n");
    }
}
