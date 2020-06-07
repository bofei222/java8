package com.bf.JUC.thread.mizhoux;

import java.util.ArrayList;
import java.util.List;

public class RunnableTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("使用Runnable 获得返回结果：");
        Long start = System.currentTimeMillis();
        List<Thread> threads = new ArrayList<>();
        List<AccumRunnable> tasks = new ArrayList<>();
        int total = 0;
        // 新建10个线程，每个线程分别负责累加 1~10，11~20， 21~30......91~100
        for (int i = 0; i < 10; i++) {
            AccumRunnable task = new AccumRunnable(i * 10 + 1, (i + 1) * 10);
            Thread thread = new Thread(task, "慢速累加器线程" + i);
            tasks.add(task);
            threads.add(thread);
            thread.start();

            /*try {
                work.join();//Waits for this thread to die
                total += task.getResult();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
        for (int i = 0, s = threads.size(); i < s; i++) {
//            threads.get(i).join();
            total += tasks.get(i).getResult();
        }



        System.out.println("total=========" + total);
        System.out.println("用时==========" + (System.currentTimeMillis() - start));

    }

    static final class AccumRunnable implements Runnable {
        private final int begin;
        private final int end;

        private int result;

        public AccumRunnable(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }

        @Override
        public void run() {
            result = 0;
            try {
                for (int i = begin; i <= end; i++) {
                    result += i;
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("%S------%d\n",Thread.currentThread().getName(), result);
        }

        public int getResult() {
            return result;
        }
    }
}
