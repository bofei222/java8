package com.bf.JUC.thread.demo4;

public class Input implements Runnable {
    private Resource resource;

    public Input(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            synchronized (resource) {
                if (resource.flag) {
                    try {
                        resource.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (i % 2 == 0) {
                    resource.name = "张三";
                    resource.sex = "男";
                    resource.count = i;

                    System.out.println("生产 " + i);
                } else {
                    resource.name = "lisi";
                    resource.sex = "nv";
                    resource.count = i;
                    System.out.println("生产 " + i);
                }

                resource.flag = true;
                resource.notify();
                i++;
            }

        }
    }
}
