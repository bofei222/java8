package com.bf.java8.stream;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;

/**
 * Created by bofei on 18-6-20.
 */

class ShopCar {
    private String name;
    private Double price;
    private Integer count;

    public ShopCar(String name, Double price, Integer count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getCount() {
        return count;
    }
}

/**
 * map 处理数据
 * reduce 分析数据
 */
public class TestDemo {
    public static void main(String[] args) {
        List<ShopCar> shopCars = Arrays.asList(
                new ShopCar("a",100.0,10),
                new ShopCar("b",200.0,20),
                new ShopCar("c",300.0,30));
//        System.out.println(shopCars.stream().map((x) -> x.getCount()*x.getPrice()).reduce((x,y) -> x + y).get());
        DoubleSummaryStatistics dss = shopCars.stream().mapToDouble((sc) -> sc.getCount()*sc.getPrice()).summaryStatistics();
        System.out.println(dss.getMax());
        System.out.println(dss.getAverage());
        System.out.println(dss.getCount());
        System.out.println(dss.getSum());
    }

}
