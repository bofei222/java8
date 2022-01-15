package com.bf.net.tcp.chat.a.demo03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:
 * @author: bofei
 * @date: 2021-04-01 23:05
 **/
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9999);
        while (true) {
            Socket socket = server.accept();

//            while (true) {
//                // 输入流
//                DataInputStream dis = new DataInputStream(socket.getInputStream());
//                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
//                String msg = dis.readUTF();
//                // 输出流
//                dos.writeUTF("服务器-->" + msg);
//                dos.flush();
//            }
        }
    }

    class MyChannel implements Runnable {
        private DataInputStream dis;
        private DataOutputStream dos;
        private boolean isRunning = true;
//        private Socket socket;

        public MyChannel(Socket socket) {
            try {
                dis = new DataInputStream(socket.getInputStream());
                dos = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {

                CloseUtil.closeAll(dis, dos);
            }
        }

        @Override
        public void run() {
            try {
                while (true) {
                    String msg = dis.readUTF();
                    // 输出流
                    dos.writeUTF("服务器-->" + msg);
                    dos.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
