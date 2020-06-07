package com.bf.JUC.thread;

import java.util.concurrent.*;

public class Call {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Race tortoise = new Race("老不死", 1000);
        Race rabbit = new Race("小兔子", 500);

        Future<Integer> result = executorService.submit(tortoise);
        Future<Integer> result2 = executorService.submit(rabbit);

        Thread.sleep(2000);
        tortoise.setFlag(false);
        rabbit.setFlag(false);

        Integer num = result.get();
        Integer num2 = result2.get();
        System.out.println("乌龟跑了-->" + num + "步");
        System.out.println("兔子跑了-->" + num2 + "步");
        //
        executorService.shutdown();

    }
}

class Race implements Callable<Integer> {
    private String name;
    private long time;
    private boolean flag = true;
    private int step = 0;

    public Race(String name) {
        this.name = name;
    }

    public Race(String name, long time) {
        this.name = name;
        this.time = time;
    }

    @Override
    public Integer call() throws Exception {
        while (flag) {
            Thread.sleep(time);
            step++;
        }
        return step;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setSteep(int step) {
        this.step = step;
    }
}
