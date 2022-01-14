package com.bf.java8;

import java.util.Arrays;

@FunctionalInterface
interface InterfaceWithDefaultMethod {
    void apply(Object obj);
    
    int hashCode();
//    void apply2(Object obj);
    
    default void say(String name) {
        System.out.println("hello " + name);
    }
    
    static int sum(int[] array) {
        return Arrays.stream(array).reduce((a, b) -> a+b).getAsInt();
    }
    
}
