package com.bf.timedemo;

import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.YEAR;

/**
 * @description:
 * @author: bofei
 * @date: 2021-02-02 09:03
 **/
public class TimeTest2 {
    public static void main(String[] args) {
        System.out.println(new Date());
//        //calendar可以将时间精确到毫秒
//        Calendar calendar = new GregorianCalendar();
//        System.out.println("年："+calendar.get(Calendar.YEAR));
//        System.out.println("月："+(calendar.get(Calendar.MONTH)+1));
//        System.out.println("日："+calendar.get(Calendar.DAY_OF_MONTH));
//        System.out.println("时："+calendar.get(Calendar.HOUR_OF_DAY));
//        System.out.println("分："+calendar.get(Calendar.MINUTE));
//        System.out.println("秒："+calendar.get(Calendar.SECOND));
//        System.out.println("毫秒："+calendar.get(Calendar.MILLISECOND));


        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        calendar.add(Calendar.DATE, -1);
        Date yesterday = calendar.getTime();
        System.out.println(yesterday);
    }
}
