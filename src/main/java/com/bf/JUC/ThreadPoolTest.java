package com.bf.JUC;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: bofei
 * @date: 2020-09-24 11:59
 **/
public class ThreadPoolTest {
    public static void main(String[] args) {
        // 这里把corePoolSize设为5，keepAliveTime保持不变
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5,
                3L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(15));
        // 允许核心线程超时销毁
        executor.allowCoreThreadTimeOut(true);
        for (int i = 0; i < 20; i++) {
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }
    }
}
