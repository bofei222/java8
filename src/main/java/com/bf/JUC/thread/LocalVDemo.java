package com.bf.JUC.thread;

import org.junit.Test;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: bofei
 * @date: 2020-06-10 19:19
 **/
public class LocalVDemo {

    // 模拟 在一个 方法中 对 一个 对象 多线程修改
    @Test
    public void test6() {
        HashMap<Object, Object> hashMap = new HashMap<>();
        new Thread(() -> {
            hashMap.put(1, "a");
        });
        new Thread(() -> {
            hashMap.remove(1, "a");
        });
    }
    // 模拟 在一个 方法中 对 一个 变量 多线程修改
    @Test
    public void test2() {
        AtomicInteger a = new AtomicInteger(100);
        new Thread(() -> {
            a.getAndDecrement();
        });
    }

    /*@Test
    public void test4() {
        int a = 100;
        new Thread(() -> {
            a--;
        });
    }
    @Test
    public void test() {
         int a = 100;
        new Thread(() -> {
            a--;
        });
    }*/

    // 又变成 全局变量了
    @Test
    public void test3() {
        new InnerClass();
    }
    class InnerClass implements Runnable {
        private int i;
        @Override
        public void run() {
            i--;
        }
    }

}
