package com.bf.thread.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author bofei
 * @Date 2019/7/7 14:31
 * @Description
 */
public class BasicFuture0 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(10);
        Future<Integer> f = es.submit(() ->{
            // 长时间的异步计算
            // ……
            // 然后返回结果
            return 100;
        });
        while(!f.isDone())
            ;
        f.get();
    }
}