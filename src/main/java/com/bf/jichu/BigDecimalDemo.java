package com.bf.jichu;

import java.math.BigDecimal;

/**
 * @description: 不可见字符
 * @author: bofei
 * @date: 2020-07-02 11:18
 **/
public class BigDecimalDemo {
    public static void main(String[] args) {
        String a = "150.3210\u202C";
        String b = "\u202D2520.0000";
        String s = cleanTextContent(a);
        String s2 = cleanTextContent(b);
        BigDecimal bigDecimal = new BigDecimal(s);
        BigDecimal bigDecimal2 = new BigDecimal(s2);

        System.out.println(bigDecimal);
        System.out.println(bigDecimal2);
    }

    private static String cleanTextContent(String text) {
        // strips off all non-ASCII characters
        text = text.replaceAll("[^\\x00-\\x7F]", "");

        // erases all the ASCII control characters
        text = text.replaceAll("[\\p{Cntrl}&&[^\r\n\t]]", "");

        // removes non-printable characters from Unicode
        text = text.replaceAll("\\p{C}", "");

        return text.trim();
    }
}
