package com.bf.test;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * @description:
 * @author: bofei
 * @date: 2023-05-10 11:59
 **/
public class GFG {
    public static void main(String[] args)
            throws IOException {

        // Create byte array
        byte[] b = {-20, -10, 0, 10, 20};

        // Create byte array input stream
        ByteArrayInputStream byteArrayInputStr
                = new ByteArrayInputStream(b);

        // Convert byte array input stream to
        // DataInputStream
        DataInputStream dataInputStr
                = new DataInputStream(
                byteArrayInputStr);

        while (dataInputStr.available() > 0) {
            // Print bytes
            int i = dataInputStr.readUnsignedByte();
            System.out.println(i);

            byte b1 = (byte) i;
            System.out.println(b1);
        }
    }
}