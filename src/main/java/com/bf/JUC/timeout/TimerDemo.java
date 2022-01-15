//package com.bf.JUC.timeout;
//
//import java.util.Timer;
//import java.util.TimerTask;
//
///**
// * @description:
// * @author: bofei
// * @date: 2022-01-12 17:08
// **/
//public class TimerDemo {
//
//    public static void main(String[] args) {
//        Thread t = new Thread(DelayedTask::doTask);
//        t.start();
//        TimerTask timerTask = new TimerTask() {
//            @Override
//            public void run() {
//                t.interrupt();
//            }
//        };
//        Timer timer = new Timer();
//        timer.schedule(timerTask, 20);
//    }
//
//}