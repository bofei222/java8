package com.bf.JUC.executor;

import org.junit.Test;

import java.util.concurrent.*;

public class Demo {
    public static void main(String[] args) {
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();//创建只有一个线程的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(100);//创建固定大小的线程池
        ExecutorService executorService2 = Executors.newCachedThreadPool(); //创建一个不限线程数上限的线程池，任何提交的任务都将立即执行

        ScheduledExecutorService scheduledExecutorService1 = Executors.newScheduledThreadPool(1);

        ExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        ScheduledExecutorService scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);

//        new ThreadPoolExecutor
//
//        Demo demo = new Demo();
//        demo.test();




    }

    // 源码 包 不能 自动填充， 可以 c+s+空格 单个填充
    public void test(int corePoolSize,
                       int maximumPoolSize,
                       long keepAliveTime,
                       TimeUnit unit,
                       BlockingQueue<Runnable> workQueue,
                       ThreadFactory threadFactory,
                       RejectedExecutionHandler handler) {
        new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory,handler );

    }

    @Test
    public void autoFilling() {
        String userId = "1";
        String userName = "a";
        Integer age = 10;
        printSomething(userId, userName, age);

    }

    @Test
    public void autoFillingFromParameter(String userId, String userName, Integer age) {
        printSomething(userId, userName, age);

    }

    public void autoFillingNoParameter() {
//        printSomething(userId, userName, age);  work ok
    }

    public void printSomething(String userId, String userName, Integer age) {

    }
}
