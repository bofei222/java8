package com.bf.container;

import java.util.Date;
import java.util.Objects;

public class Student {
    private int id;
    private String name;
    Date date;

    public Student(int id, String name, Date date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    public static void main(String[] args) {
        Student a = new Student(1, "a", new Date());
        Student b = new Student(1, "b", new Date());
        System.out.println(a.equals(b));

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println("------------");
        System.out.println(System.identityHashCode(1));
        System.out.println(System.identityHashCode(1));


        System.out.println("----------");

        Object o = new Object();
        System.out.println(o.hashCode());
        System.out.println(System.identityHashCode(o));
    }
}
