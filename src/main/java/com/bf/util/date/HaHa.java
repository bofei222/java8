package com.bf.util.date;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:
 * @author: bofei
 * @date: 2019-10-24 15:08
 **/
public class HaHa {
    public static void main2(String[] args) {
        Pattern p=Pattern.compile("\\d+");
        Matcher m=p.matcher("我的QQ是:456456 我的电话是:0532214 我的邮箱是:aaa123@aaa.com");
        while(m.find()) {
            System.out.println(m.group(1));
//            System.out.println(m.group());
        }
    }

    public static void main(String[] args) {
        Pattern p=Pattern.compile("([a-z]+)(\\d+)");
        Matcher m=p.matcher("aaa2223bb");
        while (m.find()) {
            System.out.println(m.group(0));
            System.out.println(m.group(1));
            System.out.println(m.group(2));
        }
    }
}
