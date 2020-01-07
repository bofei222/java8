package com.bf.util.a;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:
 * @author: bofei
 * @date: 2020-01-07 10:35
 **/
public class DateToTimestampExample1 {
    public static void main(String args[]) throws ParseException {
        String sDate1 = "2020-01-06";
        String sDate2 = "2019-12-31 10:32:30";
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format = dateFormat.format(date1);
        System.out.println("----------" + format);

        Date date2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(sDate2);
        System.out.println(sDate1 + "\t" + date1);
        //
        Timestamp ts1 = new Timestamp(date1.getTime());
        System.out.println(ts1);
//        if (date1.getTime() > date2.getTime()) {
//            System.out.println("true");
//        }


        System.out.println();
        Date date = new Date();
        System.out.println(date);
        Timestamp ts = new Timestamp(date.getTime());
        System.out.println(date.getTime());
        System.out.println(ts);

    }
}
