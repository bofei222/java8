package com.bf.net.tcp.chat.a.demo02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:
 * @author: bofei
 * @date: 2021-04-01 23:05
 **/
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9999);
        while (true) {
            Socket socket = server.accept();

            while (true) {
                // 输入流
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                String msg = dis.readUTF();
                // 输出流
                dos.writeUTF("服务器-->" + msg);
                dos.flush();
            }
        }



    }
}
