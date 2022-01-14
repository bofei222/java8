package com.bf.net.tcp.chat.demo02;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author bofei
 * @date 2018/11/28 11:04
 * 数据发送线程
 */
public class Sender implements Runnable{
    //
    private BufferedReader console;
    //
    private DataOutputStream dos;
    //
    private Boolean isRunning = true;

    public Sender() {
        console = new BufferedReader(new InputStreamReader(System.in));
    }

    public Sender(Socket client) {
        this();
        try {
            dos = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
//            e.printStackTrace();
            isRunning = false;
            CloseUtil.closeAll(dos, console);
        }
    }

    // 1.从控制台接收数据
    private String getMsgFromConsole() {
        try {
            return console.readLine();
        } catch (IOException e) {
//            e.printStackTrace();
        }
        return "";
    }

    /**
     * 2.发送数据
     */
    public void send() {
        String msg = getMsgFromConsole();
        try {
            if (null != msg && !msg.equals("")) {
                dos.writeUTF(msg);
                dos.flush(); // 强制刷新
            }
        } catch (IOException e) {
//            e.printStackTrace();
            isRunning = false;
            CloseUtil.closeAll(dos, console);
        }
    }

    @Override
    public void run() {
        while (isRunning) {
            send();
        }
    }

}
