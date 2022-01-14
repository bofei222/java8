package com.bf.JUC.executor;

/**
 * @description:
 * @author: bofei
 * @date: 2020-06-23 14:50
 **/

import java.util.concurrent.*;

/**
 * * 重写线程池，捕获了线程运行中的错误，线程开始结束时执行的方法，线程池结束时执行的
 * * @author ms
 * *
 */


public class TraceThreadPoolExecutorDemo implements Runnable {

    int a, b;


    public TraceThreadPoolExecutorDemo(int a, int b) {
        this.a = a;
        this.b = b;
    }


    public void run() {
        double i = a / b;
        System.out.println("i---" + i);
    }


    public static void main(String[] args) {
        // 结果1
//        ThreadPoolExecutor tp = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(),
                // 结果2
                ExecutorService tp=new TraceThreadPoolExecutor(5, 5, 0L, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(10),
                //        Executors.defaultThreadFactory(), //jdk 提供的默认线程工厂
                new ThreadFactory() {//自己定义的线程工厂，可以设置线程类型 名字等

                    @Override
                    public Thread newThread(Runnable r) {
                        Thread t = new Thread(r);
                        //t.setName("自己设定");
                        //t.setDaemon(true);全部设成守护线程
                        return t;
                    }

                },
                //        new ThreadPoolExecutor.DiscardPolicy()  //jdk  提供的几种拒绝策略
                new RejectedExecutionHandler() { //自己定义拒绝策略
                    //r 为要丢弃的任务，executor为当前线程池
                    //当执行下面方法的时候其实已经丢掉r任务了
                    @Override
                    public void rejectedExecution(Runnable r,
                                                  ThreadPoolExecutor executor) {
                        //executor.getQueue()  //获取当前线程的任务队列，
                        //r.run();  直接在调用者线程运行被抛弃的任务
                        //if(!executor.isShutdown())上述操作必须要在线程池未关闭的状态下
                        System.out.println(r + "任务被丢弃！");
                    }


                }
        );
        for (int i = 0; i < 5; i++) {
            tp.submit(new TraceThreadPoolExecutorDemo(5, i));
        }
        tp.shutdown();
    }
}