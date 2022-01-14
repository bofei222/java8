package com.bf.util.date;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateComparison {
    public static void main(String[] args) throws ParseException {
        LocalDate todayLocalDate = LocalDate.now();
        LocalDate anotherLocalDate = LocalDate.of(2018, 01, 10);

//        System.out.println(anotherLocalDate);
        compareLocalDates(todayLocalDate, anotherLocalDate);
    }

    private static void compareLocalDates(LocalDate todayLocalDate, LocalDate pastLocalDate) {
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date1 = sdf.format(todayLocalDate);
        String date2 = sdf.format(pastLocalDate);


        //isAfter() Method
        System.out.println(date1 + " is after " + date2 + " :: " + todayLocalDate.isAfter(pastLocalDate));    //true


        //isBefore() Method
        System.out.println(date2 + " is before " + date2 + " :: " + pastLocalDate.isBefore(todayLocalDate));  //true


        //compareTo()
        int dateDifference = todayLocalDate.compareTo(pastLocalDate);

        System.out.println("Date diff : " + dateDifference);        //6

        if (dateDifference > 0)
            System.out.println(date1 + " > " + date2);           //prints
        else if (dateDifference < 0)
            System.out.println(date1 + " < " + date2);       //does not print
        else
            System.out.println(date1 + " = " + date2);          //does not print
    }

}
