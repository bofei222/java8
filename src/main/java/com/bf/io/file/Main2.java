package com.bf.io.file;

import java.io.File;
import java.io.FileInputStream;

/**
 * @description:
 * @author: bofei
 * @date: 2020-09-09 08:07
 **/
public class Main2 {
    public static void main(String[] args) throws Exception{

        // 一次性将 大文件（2GB）全部字节读取到  byte数组中
        File cryptFile = new File("C:\\Users\\bofei\\Downloads\\manjaro-kde-18.1.1-191015-linux53.iso");
        long l = cryptFile.length();
        // 2569867264
        // 2147483647 21亿  1.99999 GB （不能超过2GB大小）
        int length = (int) l;
        // length 强转错误 得到 负数： -1725100032
        byte[] data =  new byte[length]; // 抛出异常 NegativeArraySizeException
        new FileInputStream(cryptFile).read(data);
        System.out.println(data.length);
    }
}
