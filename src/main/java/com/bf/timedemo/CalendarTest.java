package com.bf.timedemo;

import java.util.Calendar;
import java.util.Date;

/**
 * @description:
 * @author: bofei
 * @date: 2021-02-02 09:47
 **/
public class CalendarTest {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), 1, 1, 0, 0, 0);
        Date time = calendar.getTime();

        calendar.add(Calendar.DATE, -1);
        Date yesterday = calendar.getTime();

        if (yesterday.getTime() == 1612108800000L) {

        }
    }
}
