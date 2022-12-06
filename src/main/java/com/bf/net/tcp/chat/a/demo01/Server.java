package com.bf.net.tcp.chat.a.demo01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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
        server.setSoTimeout(100);

        Socket socket = server.accept();
        socket.setSoTimeout(11);
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
