package com.bf.JUC.thread.mizhoux;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableTest {

    public static void main(String[] args) {
        System.out.println("使用Callable 获得返回结果：");
        List<FutureTask<Integer>> futureTasks = new ArrayList();
        for (int i = 0; i < 10; i++) {
            AccumCallable task = new AccumCallable(i * 10 + 1, (i + 1) * 10);
            FutureTask<Integer> futureTask = new FutureTask<>(task);
            futureTasks.add(futureTask);

            Thread thread = new Thread(futureTask, "慢速累加线程器" + i);
            thread.start();
        }
        int total = 0;


    }

    static final class AccumCallable implements Callable<Integer> {
        private final int begin;
        private final int end;

        public AccumCallable(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }

        @Override
        public Integer call() throws Exception {
            int result = 0;
            for (int i = begin; i <= end; i++) {
                result += i;
                Thread.sleep(100);
            }
            System.out.printf("%s,%d", Thread.currentThread().getName(), result);
            return result;
        }
    }

}
