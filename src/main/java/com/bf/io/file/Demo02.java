package com.bf.io.file;

import java.io.File;

public class Demo02 {
    public static void main(String[] args) {
        String parent = "/home/bofei/projects";
        String chlid = "2.txt";
        File file1 = new File(parent, chlid);
        File file2 = new File(new File(parent), chlid);
        File file3 = new File("/home/bofei/projects/2.txt");

        System.out.println(file1.getName());
        System.out.println(file1.getPath());

        // 没有绝对路径，默认在workspace创建
        File file4 = new File("3.txt");
        File file5 = new File(".");
        System.out.println(file4.getPath()); // getPath() 如果建立时是绝对的返回绝对路径；是相对的，返回相对路径
        System.out.println(file4.getAbsolutePath()); // 返回绝对路径d
        System.out.println(file5.getPath());
        System.out.println(file5.getAbsolutePath());
    }
}
