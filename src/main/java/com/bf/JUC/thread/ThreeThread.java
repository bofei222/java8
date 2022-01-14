package com.bf.JUC.thread;

/**
 * @author bofei
 * @date 2018/7/11 16:18
 */
public class ThreeThread {
    public static void main(String[] args) throws InterruptedException {
        Integer gData   = 0;
        Thread  thread1 = new MyTask(gData, 0, "A");
        Thread  thread2 = new MyTask(gData, 1, "B");
        Thread  thread3 = new MyTask(gData, 2, "C");

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();
    }

}

class MyTask extends Thread {

    private Integer gData;
    private int     n;
    private String  info;

    public MyTask(Integer gData, int n, String info) {
        super("thread " + info);
        this.gData = gData;
        this.n     = n;
        this.info  = info;
    }

    public void run() {
        int i = 0;

        while (true) {
//            synchronized (gData) {
                if (gData % 3 == n) {
                    System.out.print(info + " ");
                    gData++;
                    i++;
                }
//            }

            if (i == 10) {
                break;
            }
            else {
                Thread.yield();
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
