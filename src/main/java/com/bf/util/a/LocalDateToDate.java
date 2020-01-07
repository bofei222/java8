package com.bf.util.a;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * @description:
 * @author: bofei
 * @date: 2020-01-07 15:38
 **/
public class LocalDateToDate {


    public static void main(String[] args) {

        // LocalDate to LocalDateTime
        LocalDateTime localDateTime = LocalDate.now().atStartOfDay();
        System.out.println(localDateTime);

        LocalDate localDate1 = localDateTime.toLocalDate();
        System.out.println(localDate1);
        System.out.println();


        System.out.println("LocalDate.now();" + LocalDate.now());
        System.out.println("LocalTime.now();" + LocalTime.now());
        System.out.println("LocalDateTime.now();" + LocalTime.now());


        LocalDate localDate = LocalDate.parse("2018-06-23");

//        Text '2018-06-23 12:00:00' could not be parsed,
//        LocalDate localDate2 = LocalDate.parse("2018-06-23 12:00:00");

        System.out.println(localDate);
        Date date = LocalDateToDate.convertToDateViaSqlDate(localDate);
        System.out.println(date);
        System.out.println();



        LocalDateTime endOfDateTime = LocalTime.MAX.atDate(localDate);
        System.out.println(endOfDateTime);
        Date endOfDate = LocalDateToDate.convertToDateViaSqlTimestamp(endOfDateTime);
        System.out.println(endOfDate);

//        System.out.println(endOfDate.toInstant().toEpochMilli());
    }

    public static Date convertToDateViaSqlDate(LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }

    public static Date convertToDateViaSqlTimestamp(LocalDateTime dateToConvert) {
        return java.sql.Timestamp.valueOf(dateToConvert);
    }
}
