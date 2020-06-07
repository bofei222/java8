package com.bf.JUC.thread.pro;

public class Watcher implements Runnable {
    private Movie m;

    public Watcher(Movie m) {
        this.m = m;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            m.watch();
        }
    }
}
