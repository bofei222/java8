package com.bf.httpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket server;

    public static void main(String[] args) {
        Server server = new Server();
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
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));

            while ((msg = br.readLine()).length() > 0) {
                sb.append(msg);
                sb.append("\r\n");
                if (msg == null) {
                    break;
                }
            }
            // 接受客户端请求信息
            String requestInfo = sb.toString().trim();
            System.out.println(requestInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {

    }
}
