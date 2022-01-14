package com.bf.container.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private String department;
    private Date hireDate;



    public Employee(int id, String name, double salary, String department, String strDate) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");

        try {
            this.hireDate = format.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
}
