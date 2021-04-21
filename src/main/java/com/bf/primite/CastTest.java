package com.bf.primite;

/**
 * @description:
 * @author: bofei
 * @date: 2021-02-03 20:33
 **/
public class CastTest {
    public static void main(String[] args) {
        double memPercent = (double) (Math.round(1.235*100)/100);
        System.out.println(memPercent);

        double memPercent2 = (double)Math.round(1.235*100)/100;
        System.out.println(memPercent2);

        long round = Math.round(1.235 * 100);
        System.out.println(round);

        double round2 = (double)Math.round(1.235 * 100); // round 四舍五入
        System.out.println(round2);

    }
}
