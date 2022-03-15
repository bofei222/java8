package com.bf.container.iterator;


import java.util.ArrayList;
import java.util.Iterator;

class Person{
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }
}
/**
 * @description:
 * @author: bofei
 * @date: 2022-02-09 11:28
 **/
public class Test02 {
    public static void main(String[] args) {
        ArrayList<Person> array = new ArrayList<Person>();

        Person p1 = new Person("Tom1");
        Person p2 = new Person("Tom2");
        Person p3 = new Person("Tom3");
        Person p4 = new Person("Tom4");

        array.add(p1);
        array.add(p2);
        array.add(p3);
        array.add(p4);

        Iterator<Person> iterator = array.iterator();

        for (Person pp : array){
            System.out.println(pp.getName());
        }

        System.out.println("\r\n" + "-----利用Lambda表达式的foreach-----" + "\r\n");
        array.forEach(obj -> System.out.println(obj.getName()));


        System.out.println("\r\n" + "-----利用for循环-----" + "\r\n");
        for(Person p : array){
            p.setName("wang");
        }

        while(iterator.hasNext()){
            System.out.println(iterator.next().getName()); //输出的是wang，而不是tom
        }



    }


}
