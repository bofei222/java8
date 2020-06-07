package com.bf.JUC.thread.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Author bofei
 * @Date 2019/7/7 11:20
 * @Description
 */
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        compute();
    }

    public static CompletableFuture<Integer> compute() {
        final CompletableFuture<Integer> future = new CompletableFuture<>();
        return future;
    }

}
