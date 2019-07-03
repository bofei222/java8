package com.bf.net.tcp.socket;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author bofei
 * @date 2018/11/27 19:24
 */
public class Server {
    public static void main(String[] args) {
        // 1024以下的不要使用
        try (ServerSocket server = new ServerSocket(8888)) {

            // 接收客户端连接 阻塞式
            Socket socket = server.accept();
            //浏览器也是一个基于tcp的客户端
            System.out.println("一个客户端建立连接");
            // 发送数据
            String msg = "欢迎使用";
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write(msg);
            // 加入换行
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
