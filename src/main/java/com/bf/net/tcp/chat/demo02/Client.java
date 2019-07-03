package com.bf.net.tcp.chat.demo02;

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

        Socket client = new Socket("localhost", 9999);
        new Thread(new Sender(client)).start();
        new Thread(new Receive(client)).start();

    }

    public static void main2(String[] args) {
        System.out.println();


    }
}
