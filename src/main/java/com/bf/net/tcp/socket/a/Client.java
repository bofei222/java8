package com.bf.net.tcp.socket.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @description:
 * @author: bofei
 * @date: 2021-04-01 22:41
 **/
public class Client {
    public static void main(String[] args) throws IOException {
        // 1.创建客户端
        Socket socket = new Socket("127.0.0.1", 8888);
        // 2.接收数据
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String echo = br.readLine(); // 堵塞
        System.out.println(echo);

    }
}
