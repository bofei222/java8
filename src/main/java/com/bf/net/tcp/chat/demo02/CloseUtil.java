package com.bf.net.tcp.chat.demo02;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author bofei
 * @date 2018/11/28 11:16
 */
public class CloseUtil {
    public static void closeAll(Closeable... io) {
        for (Closeable temp : io) {
            try {
                if (null != temp) {
                    temp.close();
                }
            } catch (IOException e) {
//                e.printStackTrace();
            }
        }
    }
}
