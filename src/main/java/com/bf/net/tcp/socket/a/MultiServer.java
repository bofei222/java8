package com.bf.net.tcp.socket.a;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:
 * @author: bofei
 * @date: 2021-04-01 22:38
 **/
public class MultiServer {
    public static void main(String[] args) throws IOException {
        //  1.创建服务器 指定端口
        ServerSocket server = new ServerSocket(8888);

        while (true) {
            // 2.接收客户端的连接 堵塞式
            Socket socket = server.accept();
            System.out.println("一个客户端建立连接");

            // 3.发送数据和接收数据
            String s = "我是服务器";
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write(s);
            bw.newLine();
            bw.flush();

        }

    }
}
