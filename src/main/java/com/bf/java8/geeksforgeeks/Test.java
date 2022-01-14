package com.bf.java8.geeksforgeeks;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Supplier;

interface FuncInterface {
    // An abstract function
    void abstractFun(int x);

    // A non-abstract (or default) function
    default void normalFun() {
        System.out.println("Hello");
    }
}

/**
 * Supplier
 * Consumer
 * Predicate
 * Function
 *
 */
public class Test {
    public static void main(String[] args) {
        // lambda expression to implement above
        // functional interface. This interface
        // by default implements abstractFun()
        FuncInterface fobj = (int x) -> System.out.println(2 * x);

        // This calls above lambda expression and prints 10.
        fobj.abstractFun(5);

        Supplier c = () -> {
            System.out.println("12");
            return "1";
        };
        c.get();

        // Creating an ArrayList with elements
        // {1, 2, 3, 4}
        ArrayList<Integer> arrL = new ArrayList<Integer>();
        arrL.add(1);
        arrL.add(2);
        arrL.add(3);
        arrL.add(4);

        // Using lambda expression to print all elements
        // of arrL
        arrL.forEach((x) -> {
            System.out.println(x);
        });

//        我要自己 写一个 这个foreach 方法的作用
    }
}
