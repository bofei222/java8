package com.bf.predicateExample;

import lombok.Data;

/**
 * @description:
 * @author: bofei
 * @date: 2020-04-29 17:56
 **/
@Data
public class Employee {

    public Employee(Integer id, Integer age, String gender, String fName, String lName) {
        this.id = id;
        this.age = age;
        this.gender = gender;
        this.firstName = fName;
        this.lastName = lName;
    }

    private Integer id;
    private Integer age;
    private String gender;
    private String firstName;
    private String lastName;

    //Please generate Getter and Setters

    //To change body of generated methods, choose Tools | Templates.
    @Override
    public String toString() {
        return this.id.toString() + " - " + this.age.toString();
    }
}
