package com.bf.net.tcp.chat.a.demo01;

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

        Socket socket = new Socket("127.0.0.1", 3131);

//        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
//        DataInputStream dis = new DataInputStream(socket.getInputStream());

//        while (true) {
//            String info = console.readLine();
//            // 输出流
        dos.writeUTF( "F1110,GF_001,DO1247,0,FBCh1gEFeo,2022-10-19_12:51:54.071,da63");
            dos.flush();
//            // 输入流
//            String msg = dis.readUTF();
//            System.out.println(msg);
            socket.close();
//        }

    }
}
