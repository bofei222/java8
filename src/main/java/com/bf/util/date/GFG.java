package com.bf.util.date;

import java.math.BigDecimal;

/**
 * @description:
 * @author: bofei
 * @date: 2019-10-23 09:30
 **/
class GFG {
    public static void main(String[] args)
    {

        // Create a BigDecimal object
        BigDecimal a;

        // Create a String object
        String s;

        a = new BigDecimal("4536785E10");

        // apply toPlainString() method
        s = a.toPlainString();

        // print the result
        System.out.println(s);
    }
    public static void main2(String[] args)
    {
        // Creating a BigDecimal object
        BigDecimal b;

        // Object of String to hold the number
        String input = "012345678901234567"
                + "8901234567890123"
                + "4567890123456789"
                + "0123456789012345"
                + "6789012345678901"
                + "2345678901234567"
                + "8901234567890123"
                + "4567890123456789"
                + "0123456789012345"
                + "6789012345678901"
                + "2345678901234567"
                + "8901234567890123"
                + "4567890123456789"
                + "0123456789012345"
                + "6789012345678901"
                + "2345678901234567"
                + "8901234567890123"
                + "4554324324362432"
                + "7674637264783264"
                + "7832678463726478"
                + "3264736274673864"
                + "7364732463546354"
                + "6354632564532645"
                + "6325463546536453"
                + "6546325463546534"
                + "6325465345326456"
                + "4635463263453264"
                + "654632498739473";

        // Converting to BigDecimal
        b = new BigDecimal(input);

        // Apply toPlainString() method
        String s = b.toPlainString();

        // Print the result
        System.out.println(s);

        String s1 = b.toString();
        System.out.println(s1);




    }
}
