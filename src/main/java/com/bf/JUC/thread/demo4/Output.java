package com.bf.JUC.thread.demo4;

public class Output implements Runnable {

    private Resource resource;

    public Output(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (resource) {
                if (!resource.flag) {
                    try {
                        resource.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("消费" + resource.name + ": " + resource.sex + " " + resource.count);
                resource.flag = false;
                resource.notify();
            }
        }
    }
}
