package com.bf.net.tcp.chat.a.demo02;

import java.io.*;
import java.net.Socket;

/**
 * @description:
 * @author: bofei
 * @date: 2021-04-07 22:33
 **/
public class Send implements  Runnable{
    private BufferedReader console;
    private DataOutputStream dos;

    private boolean isRunning = true;

    public Send() {
        this.console = new BufferedReader(new InputStreamReader(System.in));
    }

    public Send(Socket socket) {
        this();
        try {

            this.dos =  new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
//            e.printStackTrace();
            isRunning = false;
            CloseUtil.closeAll(dos, console);

        }
    }

    private String getMsgFromConsole() {
        try {
            return console.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    public void send() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String msg = getMsgFromConsole();
        if (null != msg && !"".equals(msg)) {
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                CloseUtil.closeAll(dos, console);
            }

        }
    }

    @Override
    public void run() {
        while (isRunning) {
            send();
        }
    }
}
