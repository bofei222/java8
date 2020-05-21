package com.bf.java8.mkyong;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @description:
 * @author: bofei
 * @date: 2020-05-21 19:04
 **/
public class StreamDemo {
    public static void main(String[] args) {
        List<String> invoices = new LinkedList<>();
        invoices.add(String.valueOf(9.9));
        invoices.add(String.valueOf(1.0));
        invoices.add(String.valueOf(19.99));
        invoices.add(String.valueOf(0.2));
        invoices.add(String.valueOf(5.5));

        Stream<BigDecimal> bigDecimalStream = invoices.stream().map(BigDecimal::new);
    }
}
