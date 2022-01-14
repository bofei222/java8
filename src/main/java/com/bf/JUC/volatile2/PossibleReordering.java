package com.bf.JUC.volatile2;

public class PossibleReordering {

    static int x = 0, y = 0;
    static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        for (; ; ) { // 1要循环， 推出条件 在 循环内
            Thread one = new Thread(() -> {
                a = 1;
                x = b;
            });

            Thread other = new Thread(() -> {
                b = 1;
                y = a;
            });
            one.start();
            other.start();
            one.join();
            other.join();
            i++; // 另外在  统计次数
            if (x == 0 && y == 0) { // 符合条件 打印的 同时，break 退出循环
                System.out.println(i +": (" + x + "," + y + ")");
                break;
            }
        }
    }
}
