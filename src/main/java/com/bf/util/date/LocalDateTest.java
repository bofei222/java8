package com.bf.util.date;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class LocalDateTest {
    public static void main(String[] args) {
        LocalDateTest test = new LocalDateTest();

        Date date = new Date();
        System.out.println(date);

        System.out.println(LocalDate.now());
        LocalDate now = LocalDate.now();

        System.out.println(test.convertToDateViaInstant(now));
        System.out.println(test.convertToLocalDateViaInstant(date));

        test();

    }
    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public Date convertToDateViaInstant(LocalDate dateToConvert) {
        return java.util.Date.from(dateToConvert.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }

    /**
     * @Author bofei
     * @Date 9:21 2019/6/14
     * @Param []
     * @return void
     * @Description String to LocalDate | LocalDate to String   parse | format
     */
    public static void test() {
        // String to LocalDate
        LocalDate yyyyMMdd = LocalDate.parse("20190614", DateTimeFormatter.ofPattern("yyyyMMdd")).plusDays(-30);
        System.out.println(yyyyMMdd);
        // LocalDate to String
        String from_issue = yyyyMMdd.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        System.out.println(from_issue);
    }
}
