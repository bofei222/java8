package com.bf.timedemo;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @description:
 * @author: bofei
 * @date: 2021-02-02 09:42
 **/
public class Test2 {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now().withNano(0);
        System.out.println(localDateTime);
        Date date = Date.from(localDateTime.atZone( ZoneId.systemDefault()).toInstant());

        System.out.println(date);
    }
}
