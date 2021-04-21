package com.bf.net.tcp.chat.a.demo02;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @description:
 * @author: bofei
 * @date: 2021-04-07 22:34
 **/
public class Receive implements  Runnable{
    private DataInputStream dis;
    private boolean isRunning = true;
    public Receive() {
    }

    public Receive(Socket socket) {

        try {
            this.dis = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            isRunning = false;
            CloseUtil.closeAll(dis);
        }
    }

    public String receive() {
        String msg = "";
        try {
            msg = dis.readUTF();
        } catch (IOException e) {
            isRunning = false;
            CloseUtil.closeAll(dis);

        }
        return msg;
    }

    @Override
    public void run() {
        while (isRunning) {
            System.out.println(receive());
        }
    }
}
