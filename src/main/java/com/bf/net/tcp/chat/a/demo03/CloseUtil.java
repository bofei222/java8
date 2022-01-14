package com.bf.net.tcp.chat.a.demo03;

import java.io.Closeable;
import java.io.IOException;

/**
 * @description:
 * @author: bofei
 * @date: 2021-04-07 22:38
 **/
public class CloseUtil {
    public static void closeAll(Closeable... io) {
        for (Closeable closeable : io) {
            if (null != closeable) {
                try {
                    closeable.close();
                } catch (IOException e) {
//                    e.printStackTrace();
                }
            }
        }

    }
}
