package com.bf;

/**
 * @author bofei
 * @date 2018/8/6 16:57
 */
public class ThreadLocalTest {

    ThreadLocal<String> mStringThreadLocal = new ThreadLocal<>();

    private void testThreadLocal() {
        Thread t = new Thread() {
            ThreadLocal<String> mStringThreadLocal = new ThreadLocal<>();

            @Override
            public void run() {
                super.run();
                mStringThreadLocal.set("droidyue.com");
                mStringThreadLocal.get();
            }
        };

        t.start();
    }

    ThreadLocal<String> mThreadLocal = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return Thread.currentThread().getName();
        }
    };


}
