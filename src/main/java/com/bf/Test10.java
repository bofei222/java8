package com.bf;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Test10 {
    static int refreshCycle = 1000;
    public static void main(String[] args) throws InterruptedException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        while (true) {
            System.out.println("hello");

            Date collectStartTime = new Date();
            System.out.println("采集任务开始时间：" + sdf.format(collectStartTime));
            // 记录每次循环开始时的基准时间点
            long baselineTime = System.currentTimeMillis();

            // 如果是偶数毫秒数则睡900ms，否则睡1100ms
            if (baselineTime % 2 == 0) {
                TimeUnit.MILLISECONDS.sleep(750);
            } else {
                TimeUnit.MILLISECONDS.sleep(1100);
            }



            // 计算需要休眠的时间，保证下一次任务从0毫秒开始
            long sleepMil = Math.max(0, refreshCycle - (System.currentTimeMillis() % refreshCycle));
            // 线程休眠指定的时间
            TimeUnit.MILLISECONDS.sleep(sleepMil);
        }

    }
}

