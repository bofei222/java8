package com.bf.jichu;

public class TestOverride {
    public static void main(String[] args) {
        Horse h = new Horse();
        h.run();
    }
}

class Vehicle {
    public void run() {
        System.out.println("Vehicle.run");
    }
    public void stop() {
        System.out.println("Vehicle.stop");
    }
    public Person who() {
        return new Person();
    }
}

class Horse extends Vehicle{
    public void run() {
        System.out.println("Horse.run");
    }
    public Person who() {
        return new Person();
//        return new Student();
    }
}

class Student extends Person {

}
class Person extends Animal {

}
class Animal {

}