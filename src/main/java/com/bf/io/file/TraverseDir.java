package com.bf.io.file;


import com.bf.io.file.MyFile;

import java.util.LinkedList;

/**
 * @author bofei
 * @date 2018/9/4 14:03
 */
public class TraverseDir {
    static int id = 1;
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
//        traverseFolder1("F:/path0"); // 52s 38s 38s 25s
        MyFile myFile = new MyFile("F:/Food");
        myFile.setId(id);
        traverseFolder2(myFile);// 39s  38s 25s
//        System.out.println(System.currentTimeMillis() - l);
    }
    public static void traverseFolder1(String path) {
        int MyFileNum = 0, folderNum = 0;
        MyFile MyFile = new MyFile(path);
        if (MyFile.exists()) {
            LinkedList<MyFile> list = new LinkedList<MyFile>();
            MyFile[] MyFiles = MyFile.listFiles();
            for (MyFile MyFile2 : MyFiles) {
                if (MyFile2.isDirectory()) {
//                    System.out.println("文件夹:" + MyFile2.getAbsolutePath());
                    list.add(MyFile2);
//                    MyFileNum++;
                } else {
//                    System.out.println("文件:" + MyFile2.getAbsolutePath());
//                    folderNum++;
                }
            }
            MyFile temp_MyFile;
            while (!list.isEmpty()) {
                temp_MyFile = list.removeFirst();
                MyFiles = temp_MyFile.listFiles();
                for (MyFile myFile2 : MyFiles) {
                    if (myFile2.isDirectory()) {

//                        System.out.println("文件夹:" + MyFile2.getAbsolutePath());
                        list.add(myFile2);
//                        MyFileNum++;
                    } else {
//                        System.out.println("文件:" + MyFile2.getAbsolutePath());
//                        folderNum++;
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
//        System.out.println("文件夹共有:" + folderNum + ",文件共有:" + MyFileNum);
    }


    public static void traverseFolder2(MyFile myFile) {
            MyFile[] myFiles = myFile.listFiles();

                for (MyFile myFile2 : myFiles) {
                    myFile2.setId(++id);
                    System.out.println(myFile2.getId() + " " + myFile2.getName() + " " + myFile.getId());
                    if (myFile2.isDirectory()) {
//                        System.out.println("文件夹:" + MyFile2.getAbsolutePath());
                        traverseFolder2(myFile2);
                    } else {
//                        System.out.println("文件:" + MyFile2.getAbsolutePath());
                    }
                }
    }

}
