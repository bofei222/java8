package com.bf.timedemo;

/**
 * @description:
 * @author: bofei
 * @date: 2021-07-07 15:49
 **/
public class Test1 {
    public static void main(String[] args) {

        String s = "PitAxis1Ang";

        boolean griReactivePowerTotal = s.contains("GriReactivePowerTotal");
        boolean griActivePowerTotal = s.contains("GriActivePowerTotal");
        System.out.println(griReactivePowerTotal);
        System.out.println(griActivePowerTotal);

//        LocalDateTime now = LocalDateTime.now(ZoneOffset.UTC);
//
//        LocalDateTime ldt = now.plusHours(-1);
//        System.out.println(ldt);
//        String date = ldt.toString() + "Z";
//        System.out.println(date);
//        Date dt = Date.from(ldt.toInstant(ZoneOffset.of("+8")));
//        System.out.println(dt);
    }
}
