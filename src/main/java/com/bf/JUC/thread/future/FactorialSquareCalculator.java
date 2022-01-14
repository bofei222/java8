package com.bf.JUC.thread.future;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @description:
 * @author: bofei
 * @date: 2021-09-21 08:39
 **/
public class FactorialSquareCalculator extends RecursiveTask<Integer> {

    private Integer n;

    public FactorialSquareCalculator(Integer n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n <= 1) {
            return n;
        }

        FactorialSquareCalculator calculator
                = new FactorialSquareCalculator(n - 1);
        try {

        calculator.fork();

            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return n * n + calculator.join();
    }

    public static void main(String[] args) {
//        FactorialSquareCalculator fsc = new FactorialSquareCalculator(4);
//        System.out.println(fsc.compute());

        // 与上一种直接创建 区别有吗
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        FactorialSquareCalculator calculator = new FactorialSquareCalculator(10);
        // 为什么没有返回值?
        forkJoinPool.execute(calculator);

    }
}