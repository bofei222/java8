package com.bf;

import java.awt.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:
 * @author: bofei
 * @date: 2019-08-22 10:46
 **/
public class TimeTest {
    public static void main(String[] args) {
//        Long time = 1566057600000L;

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String format1 = format.format(new Date(1566057600000L));
        String format2 = format.format(1566057600000L);

        System.out.println(format1);

        long l = System.currentTimeMillis();
        System.out.println(format.format(l));
        Date date = new Date();

        System.out.println(new Timestamp(System.currentTimeMillis()));
        System.out.println(new Date(System.currentTimeMillis()));
        System.out.println(new Date());

        long l1 = System.nanoTime();
        System.out.println(l1);
        System.out.println(new Timestamp(l1));
    }
}
