package com.bf.io.file;

import java.io.File;

/**
 * @author bofei
 * @date 2018/9/4 13:17
 */
public class MKDirDemo {
    public static void main(String[] args) {
        File file_date = new File("F:\\yyy\\2015-12-22");
        // 如果该日期的文件夹存在，就把获得的指令文件夹建到该文件夹下。
        // 如果该日期的文件夹不存在，就新建一个日期的文件夹。
        if (file_date.exists()) {
            System.out.println("该日期的文件夹已经存在！");
        } else {
//如果直接写下面的一句话，就会说：文件建立失败。因为父文件yyy不存在。

//            boolean file_true = file_date.mkdir();

//但是写下面的这句话，就不会报错：文件夹建立失败。因为它会自动建立不存在的父文建夹。

        boolean file_true = file_date.mkdirs();
            if (file_true) {
                System.out.println("文件夹建立成功");
            } else {
                System.out.println("文件建立失败");
                return;
            }

        }
    }
}
