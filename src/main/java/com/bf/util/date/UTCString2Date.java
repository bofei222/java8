package com.bf.util.date;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

/**
 * @description:
 * @author: bofei
 * @date: 2020-08-15 16:39
 **/
public class UTCString2Date {

    public static void main(String args[]) {

//            String timestampAsString = "2020-04-27T12:40:50.33066347Z";  // 2020-04-28 05:51:56 Date 就是毫秒，  .3306634 是 3306634/100 秒 = 3306.634s，= 9.15小时，
        String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSS'Z'";
        String timestampAsString = "2020-04-27T12:40:50.1234567Z";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime localDateTime = LocalDateTime.from(formatter.parse(timestampAsString));
        System.out.println(localDateTime);

        OffsetDateTime odt = localDateTime.atOffset(ZoneOffset.UTC); // 设置时区，2020-04-27 20:40:50.1234567

        Instant instant = odt.toInstant();
        java.sql.Timestamp ts = java.sql.Timestamp.from(instant);
        System.out.println(ts);

        Timestamp timestamp = Timestamp.valueOf(localDateTime); // 不设置时区，2020-04-27 12:40:50.1234567  差8小时
        System.out.println(timestamp);
    }

    public static void main02(String args[]) {

//        String UTC = "2017-11-09T23:16:03.562Z";
        // LocalDateTime 才能 纳秒
        String UTC = "2020-04-27T12:40:50.33066347Z";  // 2020-04-28 05:51:56 Date 就是毫秒，  .3306634 是 3306634/100 秒 = 3306.634s，= 9.15小时，

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//        System.out.println(TimeZone.getTimeZone("UTC"));
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date UtcDate = null;
        try {
            UtcDate = sdf.parse(UTC);
        } catch (Exception e) {
            return;
        }
        System.out.println(UtcDate);

        SimpleDateFormat localFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(TimeZone.getDefault());
        localFormater.setTimeZone(TimeZone.getDefault());
        String localTime = localFormater.format(UtcDate.getTime());
        System.out.println(localTime);
    }
}
