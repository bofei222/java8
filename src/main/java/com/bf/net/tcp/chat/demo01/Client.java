package com.bf.net.tcp.chat.demo01;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author bofei
 * @date 2018/11/28 10:37
 * 输入流和输出流在同一个线程内 应该 独立处理 彼此独立
 */
public class Client {
    public static void main(String[] args) throws Exception{

        Socket client = new Socket("localhost", 3131);
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
