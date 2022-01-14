package com.bf.io.file;

import java.io.*;

/**
 * @description:
 * @author: bofei
 * @date: 2020-09-08 17:26
 **/
public class Main {
    public static void main(String[] args) throws Exception{
        File source = new File("");
        File dest = new File("");

        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(source);
            output = new FileOutputStream(dest);
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buf)) > 0) {
                output.write(buf, 0, bytesRead);
            }
        } finally {
            input.close();
            output.close();
        }
    }
}
