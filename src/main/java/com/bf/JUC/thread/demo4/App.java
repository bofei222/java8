package com.bf.JUC.thread.demo4;

public class App {
    public static void main(String[] args) {
        Resource resource = new Resource();
        Input input = new Input(resource);
        Output output = new Output(resource);

        new Thread(input).start();
        new Thread(output).start();
    }
}
