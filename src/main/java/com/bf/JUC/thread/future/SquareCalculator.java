package com.bf.JUC.thread.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @description:
 * @author: bofei
 * @date: 2021-09-21 08:22
 **/
public class SquareCalculator {

    private ExecutorService executor
            = Executors.newSingleThreadExecutor(); // 单线程线程池  有两个并不会并行

    public Future<Integer> calculate(Integer input) {
        return executor.submit(() -> {
            Thread.sleep(1000);
            return input * input;
        });
    }

    public static void main(String[] args) throws Exception{
        Future<Integer> future = new SquareCalculator().calculate(10);

        while(!future.isDone()) {
            System.out.println("Calculating...");
            Thread.sleep(300);
            boolean canceled = future.cancel(true);
            System.out.println(canceled);// cancel 之后 get 结果将是CancellationException
        }


        future.isCancelled();
        Integer result = future.get(); // 所以在这种情况下，future.get()将总是立即返回
        System.out.println(result);
    }
}