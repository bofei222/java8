package com.bf.JUC.thread;

public class ProgramApp {
    public static void main(String[] args) throws InterruptedException {
        Program program = new Program();
        Thread thread = new Thread(program);
        thread.start();

        for (int i = 0; i < 100; i++) {
//            Thread.sleep(10);
            System.out.println("一边聊qq..");
        }

    }
}
