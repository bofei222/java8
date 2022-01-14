package com.bf.util.date;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String s = sdf.format(new Date());
        Date date = sdf.parse(s);
        System.out.println(date);
        System.out.println("----------------------------");

// java.util.Date -> java.time.LocalDate
// java.time.LocalDate -> java.sql.Date

        Date now = new Date();
        LocalDate localDate = now.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println(localDate);

        Date sqlDate = java.sql.Date.valueOf(localDate);
        System.out.println(sqlDate);

        Date utilDate = new Date(String.valueOf(sqlDate));
        System.out.println(utilDate);


//        System.out.printf("%1$tF %1$tT\n", newDate);
    }
}
