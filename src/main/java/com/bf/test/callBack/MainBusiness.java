package com.bf.test.callBack;

/**
 * @description:
 * @author: bofei
 * @date: 2022-12-06 17:15
 **/

public class MainBusiness {

    private CallbackService callback;

    public void execute(CallbackService callback) {
        this.callback = callback;
        callBack();
    }

    public void callBack() {
        callback.callBackFunc();
    }

}
