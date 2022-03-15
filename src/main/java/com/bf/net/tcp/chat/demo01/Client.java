package com.bf.net.tcp.chat.demo01;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * @author bofei
 * @date 2018/11/28 10:37
 * 输入流和输出流在同一个线程内 应该 独立处理 彼此独立
 */
public class Client {
    public static void main(String[] args) throws Exception{

        Socket client = new Socket();
        SocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 9999);
        client.bind(socketAddress);
        client.connect(socketAddress,2000);


        // 控制台输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        DataInputStream dis = new DataInputStream(client.getInputStream());

        while (true) {
            String info = br.readLine();
            // 输出流
            dos.writeUTF(info);
            dos.flush();
            // 输入流
            String msg = dis.readUTF();
            System.out.println(msg);
        }
    }
}
