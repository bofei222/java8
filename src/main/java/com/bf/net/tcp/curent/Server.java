package com.bf.net.tcp.curent;


import com.alibaba.fastjson.JSONObject;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Server {
    private static ThreadPoolExecutor executorService = new ThreadPoolExecutor(20, 60,
            100, TimeUnit.MILLISECONDS,
            new SynchronousQueue<Runnable>(),
            new ThreadPoolExecutor.AbortPolicy());


    public static void main(String[] args){

        try {
            System.out.println("Socket服务器开始运行...");
            ServerSocket serverSocket = new ServerSocket(9999);
            int a = 0;
            while (true){

                Socket socket = serverSocket.accept();
                a ++;
//                socket.setSoTimeout(1000);

                Thread thread = new Thread(new Server_listen(socket));
                thread.setName("Thead-xx-" + a);
                executorService.submit(thread);



                Thread thread1 = new Thread(new Server_send(socket));
                thread1.setName("Thead-yy-" + a);
                Future<?> future =  executorService.submit(thread1);
                Thread.sleep(3000);
                future.cancel(true);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

class Server_listen implements Runnable{
    private Socket socket;

    Server_listen(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            while (true)
                System.out.println(ois.readObject());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                socket.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

class Server_send implements Runnable{
    private Socket socket;

    Server_send(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            while (true){
                System.out.print("请输入要发送的内容：");
                String string = scanner.nextLine();
                JSONObject object = new JSONObject();
                object.put("type","chat");
                object.put("msg",string);
                oos.writeObject(object);
                oos.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}