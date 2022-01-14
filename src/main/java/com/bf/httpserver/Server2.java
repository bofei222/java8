package com.bf.httpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
    private ServerSocket server;

    public static void main(String[] args) {
        Server2 server = new Server2();
        server.start();
    }
    public void start() {

        try {
            server = new ServerSocket(8888);

            this.receive();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void receive() {
        try {
            Socket client = server.accept();

            StringBuilder sb = new StringBuilder();
            String msg; // 接受客户端的请求信息

            byte[] data = new byte[20480];
            int len = client.getInputStream().read(data);


            // 接受客户端请求信息
            String requestInfo = new String(data, 0, len).trim();
            System.out.println(requestInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {

    }
}
