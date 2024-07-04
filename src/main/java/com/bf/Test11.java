package com.bf;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: bofei
 * @date: 2024-04-11 16:10
 **/
public class Test11 {
static  int refreshCycle = 1000;
    public static void main(String[] args) throws InterruptedException {
        while (true) {

            long start = System.currentTimeMillis();
            System.out.println(start);
            // 模拟耗时任务，可能小于1s ，也时候大于1秒
            if (start % 2 == 0) {
                TimeUnit.MILLISECONDS.sleep(750);
            } else {
                TimeUnit.MILLISECONDS.sleep(850);
            }

            long endTime = System.currentTimeMillis();
            long cost = endTime - start;
            if (cost < refreshCycle) {
                long endTimeMill = endTime % 1000;
                if (endTimeMill != 0) {
                    long sleepMil = Math.min((refreshCycle - endTimeMill), (refreshCycle - cost));
                    TimeUnit.MILLISECONDS.sleep(sleepMil);
                }
            }else {//如果 cost 大于等于 周期refreshCycle，则睡眠到整秒
                long sleepMil = Math.max(0, refreshCycle - (endTime % refreshCycle));
                TimeUnit.MILLISECONDS.sleep(sleepMil);
            }


        }
    }
}
