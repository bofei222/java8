package com.bf.stringdemo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:
 * @author: bofei
 * @date: 2021-09-01 19:13
 **/
public class MatcherTest {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("20210818*/*history.dat");
        Matcher matcher = pattern.matcher("/home/scada/data/plc-sync/20210818/history/dat/TYSFCB_149_2021_06_history.dat");
        System.out.println(matcher.matches());


        String s = "a";


    }
}
