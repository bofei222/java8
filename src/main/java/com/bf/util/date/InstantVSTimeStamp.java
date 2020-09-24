package com.bf.util.date;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;

/**
 * @description:
 * @author: bofei
 * @date: 2020-08-17 08:54
 **/
public class InstantVSTimeStamp {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        Timestamp timestamp = Timestamp.from(instant);

        System.out.println(instant);
        System.out.println(timestamp);


        System.out.println(instant.toEpochMilli());
        System.out.println(timestamp.getTime()); // 保存的 都是 在 格林威治 ，自1970年 以来 的时间
        assertEquals(instant.toEpochMilli(), timestamp.getTime());


        DateFormat df;
        df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss:SS'Z'");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        System.out.println(df.format(timestamp).toString());
        df.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        System.out.println(df.format(timestamp).toString());
    }

}
