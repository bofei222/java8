package com.bf.net.tcp.timeout.read;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author bofei
 * @date 2018/11/28 10:37
 * 创建服务器
 * 聊天室:服务器中转站
 * 1.客户端可以发送数据 + 接收数据 独立的
 * 2.为每一个客户端创建一个线程
 */
public class Server {
    public static void main(String[] args) throws Exception{
        ServerSocket server = new ServerSocket(9999);
        while (true) {
            Socket client = server.accept();
            client.setSoTimeout(20);
            // 输入流
            DataInputStream dis = new DataInputStream(client.getInputStream());
            String msg = dis.readUTF();
        }

//
//
//
//            // 输出流
//            DataOutputStream dos = new DataOutputStream(client.getOutputStream());
//            dos.writeUTF("服务器-->" + msg);
//            dos.flush();
//        }




    }
}
