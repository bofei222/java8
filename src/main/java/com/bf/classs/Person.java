package com.bf.classs;

import java.time.LocalDate;

/**
 * @description:
 * @author: bofei
 * @date: 2019-12-04 19:19
 **/
 class Person {
    private String firstName;
    private String lastName;
    private LocalDate dob;

    public Person(String firstName, String lastName, LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

//    @Override
    public String toString2() {
        return "<Person: firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ">";
    }

    @Override
    public String toString() {
        Class c = getClass();
        return "<" + c.getName() + ": firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ">";
    }
//    @Override
    public String toString3() {
        Class c = getClass();
        return "<" + c.getSimpleName() + ": firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ">";
    }

    public static void main(String[] args) {
        Person person = new Person("boo", "fei", LocalDate.now());
        System.out.println(person);
    }
}
