package com.bf.net.tcp.chat.a.demo02;

import java.io.*;
import java.net.Socket;

/**
 * @description:
 * @author: bofei
 * @date: 2021-04-01 23:05
 **/
public class Client {

    public static void main(String[] args) throws IOException {
        // 客户端可以 发送数据 可以接收数据
        // 写出数据 ：输出流
        // 读取数据 ： 输入流
        // 输入流和输入流在同一个线程内 应该独立处理

        Socket socket = new Socket("127.0.0.1", 9999);
        Thread thread = new Thread(new Send(socket));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread.start();// 一条路径
        thread.interrupt();
        new Thread(new Receive(socket)).start();

    }
}
