package com.bf.DEBUG;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Student {
    private String id;

    private String name;

    private int age;

    private boolean graduation;

    public Student(String id, String name, int age, boolean graduation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.graduation = graduation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGraduation() {
        return graduation;
    }

    public void setGraduation(boolean graduation) {
        this.graduation = graduation;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", graduation=" + graduation +
                '}';
    }

    public static void main(String[] args) {

        List<String> data = new ArrayList<String>();
        data.add("1,Ryan,25,true");
        data.add("2,zhangsan,22,false");
        data.add("3,lisi,18,false");
        data.add("4,wangwu,35,true");
        data.add("5,liliu,20,false");

        Set<String> collect = data.stream().map(d -> {
            String[] split = d.split(",");
            return new Student(split[0], split[1], Integer.parseInt(split[2]), Boolean.parseBoolean(split[3]));
        }).filter(Student::isGraduation).map(Student::getName).collect(Collectors.toSet());

        System.out.println(collect);

    }
}