package com.bf.java8.mkyong;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: bofei
 * @date: 2020-05-21 18:22
 **/
public class JavaBigDecimal {
    public static void main(String[] args) {

        List<BigDecimal> invoices = new LinkedList<>();
        invoices.add(BigDecimal.valueOf(9.9));
        invoices.add(BigDecimal.valueOf(1.0));
        invoices.add(BigDecimal.valueOf(19.99));
        invoices.add(BigDecimal.valueOf(0.2));
        invoices.add(BigDecimal.valueOf(5.5));

        // sum using a for loop
        BigDecimal sum = BigDecimal.ZERO;
        for (BigDecimal amt : invoices) {
            sum = sum.add(amt);
        }
        System.out.println("Sum = " + sum);

        // sum using stream
        BigDecimal sum2 = invoices.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Sum (Stream) = " + sum2);

        BigDecimal max = invoices.stream()
                .reduce(BigDecimal.ZERO, (a, b) -> {
            if (a.compareTo(b) > 0) return a;
            else return b;
        });
        System.out.println(max);



    }
}
