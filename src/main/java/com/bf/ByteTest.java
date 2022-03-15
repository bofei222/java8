package com.bf;

import org.junit.Test;

/**
 * @description:
 * @author: bofei
 * @date: 2022-02-08 16:15
 **/
public class ByteTest {

    public static void main(String[] args) {
        System.out.println(0xff);

    }

    @Test
    public void unsignedByteTest(){
        /**
         * 测试java如何发超过127的byte给c++接收
         * 原理：java中发送字节255到c++中的unsigned byte接收,255表示为1111 1111 ，在java中符号位1表示负数，负数存的是补码
         * 补码-1再全部取反为原码，所以~（1111 1111 - 1） = 0000 0001，所以java中把-1发给c++的unsigned byte接收就是255了
         * 总结：java发字节255，需要实际发-1（强转为byte）即可
         */
        int input = 255;
        byte send = (byte)input;
        System.out.println(send);

        /**
         * 测试java如何接收超过127的c++无符号字节
         * 原理：java 的byte 接收255，存储为1111 1111 ，java 的字节表示为-1，转回255用int存储即可。直接转为int ，会高位补和符号位一样的数，
         * 即变为1111 1111 1111 1111,这样转为int得到不是255，而是-1，需要与0xff（0000 0000 1111 1111）相与（&），把高位变为0，
         * 得到 0000 0000 1111 1111,再转为int即可得到255
         *
         * 总结：java接受字节255，接受后为-1 ， & 0xff后即可还原为255
         */
        byte javaReceive = (byte) 255;  //c++发过来的255，java中接收到为-1
        int out = javaReceive;  //直接强转int得到-1，不是255
        int expected = javaReceive & 0xff; // 得到255，期待的结果
        System.out.println(out);
        System.out.println(expected);
    }

}
