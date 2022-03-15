package com.bf.net.tcp.timeout.read;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author bofei
 * @date 2018/11/28 10:37
 * 输入流和输出流在同一个线程内 应该 独立处理 彼此独立
 */
public class Client {
    public static void main(String[] args) throws Exception {

        long t1 = 0;
        InputStream in;
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress("localhost", 9999));
            // 设置so timeout 为2000毫秒
//            socket.setSoTimeout(20);
            System.out.println("Connected.");
             in = socket.getInputStream();
            System.out.println("reading...");
            t1 = System.currentTimeMillis();
            in.read();
        } catch (IOException e) {
            long t2 = System.currentTimeMillis();
            System.out.println("read end, take -> " + (t2 - t1) + "ms");
            e.printStackTrace();
        } finally {

        }
    }
}
