package com.bf;

import java.awt.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: bofei
 * @date: 2019-08-22 10:46
 **/
public class TimeTest {
    public static void main0(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.getMonth().firstMonthOfQuarter());
        LocalDate firstDayOfQuarter = localDate.with(localDate.getMonth().firstMonthOfQuarter())
                .with(TemporalAdjusters.firstDayOfMonth());

        LocalDate lastDayOfQuarter = firstDayOfQuarter.plusMonths(2)
                .with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(firstDayOfQuarter);
    }
    public static void main(String[] args) {
        String nian = "2019";
        if (true) { //年
            System.out.println(getMonth(nian + "-01", nian + "-12"));
        }
        String bannian = "201909-202002";
        if (true) { // 半年 不定期
            String[] split = bannian.split("-");
            String x = split[0];
            String x2 = split[1];
            x = x.substring(0, 4) + "-" + x.substring(4);
            x2 = x2.substring(0, 4) + "-" + x2.substring(4);
            System.out.println(getMonth(x, x2));
        }
        String yue = "2072-12";
        if (true) { // 月
            System.out.println(getMonth(yue, yue));
        }
        String jidu = "2019-3季度";
        if (true) { // 季度
            jidu = jidu.substring(0, 6);
            Integer m = Integer.valueOf(jidu.substring(5,6));
            String year = jidu.substring(0,5);
            switch (m) {
                case 1 : getMonth(year + "01", year + "03");
                        break;
                case 2 : getMonth(year + "04", year + "06");
                    break;
                case 3 :
                    System.out.println(getMonth(year + "07", year + "09"));
                    break;
                case 4 : getMonth(year + "10", year + "12");
                    break;
            }

        }
        String zhou = "2019-01-第2周";
        if (true) { // 周
            String substring = zhou.substring(0, 7);
            System.out.println(getMonth(substring, substring));
        }
        List<String> month = getMonth("2019-01", "2022-2");
        System.out.println(month);
    }
    public static List<String> getMonth(String begin, String end) {
        StringBuffer sb = new StringBuffer();
        List<String> list = new ArrayList<>();
        sb.append("'");
        try {

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
            String nowdate = format.format(new Date());//当前月份

            Date d1 = new SimpleDateFormat("yyyy-MM").parse(begin);//定义起始日期

            Date d2 = new SimpleDateFormat("yyyy-MM").parse(end);//定义结束日期  可以去当前月也可以手动写日期。

            Calendar dd = Calendar.getInstance();//定义日期实例

            dd.setTime(d1);//设置日期起始时间


            while (dd.getTime().before(d2)) {//判断是否到结束日期

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");

                String str = sdf.format(dd.getTime());
                sb.append(str + ",");
//                sb.append("'" + str + "',");
//                System.out.println(str);//输出日期结果
                list.add(str);
                dd.add(Calendar.MONTH, 1);//进行当前日期月份加1

            }
//            System.out.println(end);//输出日期结果
//            sb.append(end + "'");
            list.add(end);
        } catch (Exception e) {
            System.out.println("异常" + e.getMessage());
        }
//        System.out.println(sb);
        return list;
    }
    public static void main2(String[] args) {
//        Long time = 1566057600000L;

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String format1 = format.format(new Date(1566057600000L));
        String format2 = format.format(1566057600000L);

        System.out.println(format1);

        long l = System.currentTimeMillis();
        System.out.println(format.format(l));
        Date date = new Date();

        System.out.println(new Timestamp(System.currentTimeMillis()));
        System.out.println(new Date(System.currentTimeMillis()));
        System.out.println(new Date());

        long l1 = System.nanoTime();
        System.out.println(l1);
        System.out.println(new Timestamp(l1));
    }
}
