package com.bf.test.callBack;

/**
 * @description:
 * @author: bofei
 * @date: 2022-12-06 17:14
 **/

public class CallBckTest {

    public static void main(String[] args) {
        MainBusiness mainBusiness = new MainBusiness();

        System.out.println("*********具体实现类实现的回调方法_固定*********");
        mainBusiness.execute(new CallbackServiceImpl());

        System.out.println("*********匿名内部类实现的回调方法_灵活*********");
        mainBusiness.execute(new CallbackService() {
            public void callBackFunc() {
                System.out.println("匿名内部类回调函数开始执行...");
                System.out.println("匿名内部类回调函数结束执行...\n");
            }
        });
    }
}
