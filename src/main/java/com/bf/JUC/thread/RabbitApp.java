package com.bf.JUC.thread;

public class RabbitApp {
    public static void main(String[] args) {
        Rabbit rabbit = new Rabbit();
        Tortoies tortoies = new Tortoies();
        rabbit.start();
        tortoies.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("RabbitApp.main" + i);
        }
    }
}
