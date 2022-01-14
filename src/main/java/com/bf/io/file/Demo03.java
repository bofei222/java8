package com.bf.io.file;

import java.io.File;
import java.io.IOException;

public class Demo03 {
    public static void main(String[] args) {
//        test1();
        test3();
    }

    public static void test1() {
        // 建立联系
        File file = new File("/home/bofei/projects/2.txt");
        File file2 = new File("2.txt");
        System.out.println(file.getParent());
        System.out.println(file2.getParent()); // 相对，返回null
    }
    public static void test2() {
        // 判断信息
        File file = new File("/home/bofei/projects/2.txt");
        File dir = new File("/home/bofei/projects");
        File file2 = new File("2.txt");
        System.out.println(file.exists());
        System.out.println(file2.exists());
        System.out.println(file.canRead() + " " + file.canWrite());
        System.out.println(file.isFile() + " " + file.isDirectory());
        System.out.println(dir.isFile() + " " + dir.isDirectory());
        System.out.println(file2.isFile() + " " + file2.isDirectory()); // 不存在 什么也不是

        System.out.println(file.isAbsolute());
        System.out.println(file.length());
        // 文件名和是文件夹和文件没关系

    }
    public static void test3() {
        // 创建和删除文件
        File file = new File("/home/bofei/projects/200.jpg");
//        File file = new File("/home/bofei/projects/con"); con是win下关键字
        if (!file.exists()) {
            try {
                boolean flag = file.createNewFile(); // 存在返回 false
                System.out.println(flag?"成功":"失败");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        file.delete();
        try {
            try {
                File bf = File.createTempFile("123", "bf");
                System.out.println(bf.getAbsolutePath());
                Thread.sleep(1000);
                bf.deleteOnExit();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
