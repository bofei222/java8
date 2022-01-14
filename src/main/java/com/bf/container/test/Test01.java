package com.bf.container.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.SimpleFormatter;

public class Test01 {
    public static void main(String[] args) throws ParseException {

        Employee e1 = new Employee(001, "远坂凛", 3000, "项目", "2007-01");
        Employee e2 = new Employee(002, "saber", 3000, "项目", "2008-02");
        Employee e3 = new Employee(003, "艾瑞莉娅", 3000, "项目", "2009-03");
        List<Employee> eList = new ArrayList<>();

        eList.add(e1);
        eList.add(e2);
        eList.add(e3);
        printAllName(eList);
    }

    public static void printAllName(List<Employee> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName());
        }
    }
}
