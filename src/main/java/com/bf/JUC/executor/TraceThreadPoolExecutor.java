package com.bf.JUC.executor;

import java.util.concurrent.*;

/**
 * @description:
 * @author: bofei
 * @date: 2020-06-23 14:52
 **/
public class TraceThreadPoolExecutor extends ThreadPoolExecutor {


    public TraceThreadPoolExecutor(int corePoolSize, int maximumPoolSize,
                                   long keepAliveTime, TimeUnit unit,
                                   BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory,
                                   RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
                threadFactory, handler);
    }


    @Override


    public Future<?> submit(Runnable task) {
        return super.submit(wrap(task, clientTrace(), Thread.currentThread().getName()));
    }

    @Override


    public void execute(Runnable command) {
        super.execute(wrap(command, clientTrace(), Thread.currentThread().getName()));
    }

    @SuppressWarnings("unused")


    private Exception clientTrace() {
        return new Exception("线程池中某个任务报错");
    }

    /**
     * 为传进了的线程增减一层异常处理
     *
     * @param task
     * @param e
     * @param clientThreadName
     * @return
     */


    private Runnable wrap(final Runnable task, Exception e, String clientThreadName) {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    task.run();
                } catch (Exception e2) {
                    e.printStackTrace();
                    e2.printStackTrace();
                }
            }
        };
    }

    /**
     * 线程开始前执行，t 将要运行任务的线程,r 将要执行的任务
     */

    @Override


    protected void beforeExecute(Thread t, Runnable r) {
        System.out.println(Thread.currentThread().getName() + "准备运行");
        super.beforeExecute(t, r);
    }

    /**
     * 线程结束后执行，
     */

    @Override


    protected void afterExecute(Runnable r, Throwable t) {
        System.out.println(Thread.currentThread().getName() + "运行结束了！");
        super.afterExecute(r, t);
    }

    /**
     * 线程池退出时执行
     */

    @Override


    protected void terminated() {
        System.out.println("线程池关闭了！");
        super.terminated();
    }
}