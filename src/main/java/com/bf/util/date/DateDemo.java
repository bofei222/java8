package com.bf.util.date;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Date;

/**
 * @description: 所以它是毫秒，或1/1000秒。你只需要用6位数字格式化，所以你需要添加3个额外的前导零..
 * @author: bofei
 * @date: 2020-08-15 16:43
 **/
public class DateDemo {
    public static void main01(String[] args) {
        Date d = new Date();
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").format(d));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS").format(d));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(d));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSS").format(d));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSS").format(d));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS").format(d));
    }

    public static void main(String[] args) {
        String input = "2020-04-27T12:40:50.3306634Z";
//        String input = "2014-11-10 04:05:06.999999";
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSS'Z'")
                .appendFraction(ChronoField.NANO_OF_SECOND, 0, 9, true) // Nanoseconds = 0-9 digits of fractional second.
                .toFormatter();
        LocalDateTime localDateTime = LocalDateTime.parse(input, formatter);
        System.out.println(localDateTime);
    }
}
