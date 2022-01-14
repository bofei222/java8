package com.bf.io.file.temp;

import java.io.File;
import java.io.IOException;

/**
 * @author bofei
 * @date 2018/12/26 14:41
 */
public class CreateTempFileTest {
    public static void main(String[] args) throws IOException {
        File.createTempFile("123", "log", new File("f:/"));
//        File.createTempFile("456", ".bofei", null);
    }
}
