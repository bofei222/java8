package com.bf.test;

import org.junit.Test;

/**
 * @description:
 * @author: bofei
 * @date: 2022-12-06 17:12
 **/


public class Main2 {

    @Test
    public void main() {

        TestBookCallBack testBookCallBack = new TestBookCallBack();
        BookCallBack bookCallBack = new BookCallBack();
        testBookCallBack.test(bookCallBack);
        System.out.println("---------main---------在主函数中 获取callback实现类里定义的变量值----------" + bookCallBack.getBookName()+"----"+ bookCallBack.getAuthor());

    }

}
