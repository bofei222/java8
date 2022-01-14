package com.bf.io.file;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @description:
 * @author: bofei
 * @date: 2020-09-09 15:59
 **/
public class BufferedInputStreamDemo {
    @Test
    public void testBufferedInput() {
        try {
            /**
             * 建立输入流 BufferedInputStream, 缓冲区大小为8
             * buffer.txt内容为
             * abcdefghij
             */
            InputStream in = new BufferedInputStream(new FileInputStream(new File("D:\\bofeiProjects\\mycode\\java8\\src\\main\\resources\\zxcvbnm")), 8);
            /*从字节流中读取5个字节*/
            byte [] tmp = new byte[5];
            int read = in.read(tmp, 0, 5);
            System.out.println(read);
            System.out.println("字节流的前5个字节为: " + new String(tmp));
            /*标记测试*/
//            in.mark(6);
            /*读取5个字节*/
            in.read(tmp, 0, 5);
            System.out.println("字节流中第6到10个字节为: " +  new String(tmp));
            /*reset*/
//            in.reset();
            System.out.printf("reset后读取的第一个字节为: %c" , in.read());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
