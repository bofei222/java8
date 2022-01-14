package com.bf.net.tcp.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author bofei
 * @date 2018/11/27 19:37
 */
public class Client {
    public static void main(String[] args) {
        // 创建客户端 指定服务器和端口
        try (Socket client = new Socket("localhost", 8888)) {
            // 客户端也是需要端口的 只不过客户端的端口由系统内部自动分配
            // tcp 是面向连接的
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String s = br.readLine();
            System.out.println(s);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
