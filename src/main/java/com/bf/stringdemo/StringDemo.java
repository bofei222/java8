package com.bf.stringdemo;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author bofei
 * @date 2018/7/23 14:16
 */
public class StringDemo {
    public static void main(String[] args) {
        String message = String.join("-", "Java", "is", "cool");
        System.out.println(message); // message returned is: "Java-is-cool"


        /*
        List<String> strings = new LinkedList<>();
        strings.add("Java");strings.add("is");
        strings.add("cool");
        String message = String.join(" ", strings);
        System.out.println(message); //message returned is: "Java is cool"
         */


        Set<String> strings = new LinkedHashSet<>();
        strings.add("Java"); strings.add("is");
        strings.add("very"); strings.add("cool");
        String message3 = String.join("-", strings); //message returned is: "Java-is-very-cool"
        System.out.println(message);
    }
}
