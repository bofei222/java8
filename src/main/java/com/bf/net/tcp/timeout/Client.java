package com.bf.net.tcp.timeout;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author bofei
 * @date 2018/11/28 10:37
 * 输入流和输出流在同一个线程内 应该 独立处理 彼此独立
 */
public class Client {
    public static void main(String[] args) throws Exception{

        Socket socket = new Socket();
        long t1 = 0;
        try {
            t1 = System.currentTimeMillis();
            socket.connect(new InetSocketAddress("10.255.10.140", 9999));
//            socket.setSoTimeout(1);
        } catch (IOException e) {
            long t2 = System.currentTimeMillis();
            e.printStackTrace();
            System.out.println("Connect failed, take time -> " + (t2 - t1) + "ms.");
        }
    }
}
