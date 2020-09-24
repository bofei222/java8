package com.bf.util.date;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Author bofei
 * @Date 9:20 2019/6/14
 * @Param String to date(LocalDate)
 * @return
 * @Description
 */
public class DateOverLap {
    public static void main(String[] args) {
        String oldstring = "2011/01-21";
        String oldstring2 = "2011/01-23";

        String oldstring3 = "2011/01-20";
        String oldstring4 = "2011/01-21";
        LocalDate start1 = LocalDate.parse(oldstring, DateTimeFormatter.ofPattern("yyyy/MM-dd"));
        LocalDate end1 = LocalDate.parse(oldstring2, DateTimeFormatter.ofPattern("yyyy/MM-dd"));
        LocalDate start2 = LocalDate.parse(oldstring3, DateTimeFormatter.ofPattern("yyyy/MM-dd"));
        LocalDate end2 = LocalDate.parse(oldstring4, DateTimeFormatter.ofPattern("yyyy/MM-dd"));
        double max = Math.max(convertToDateViaInstant(start1).getTime(), convertToDateViaInstant(start2).getTime());
        double min = Math.min(convertToDateViaInstant(end1).getTime(), convertToDateViaInstant(end2).getTime());
        if (max < min) {
            System.out.println("重叠");
        }

        boolean overlap = overlap(convertToDateViaInstant(start1), convertToDateViaInstant(end1), convertToDateViaInstant(start2), convertToDateViaInstant(end2));
        System.out.println(overlap);
    }

    static boolean overlap(Date start1, Date end1, Date start2, Date end2){
        return start1.getTime() <= end2.getTime() && start2.getTime() <= end1.getTime();
    }

    public static Date convertToDateViaInstant(LocalDate dateToConvert) {
        return java.util.Date.from(dateToConvert.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }
}
