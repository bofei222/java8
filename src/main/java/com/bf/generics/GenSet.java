package com.bf.generics;

import java.util.ArrayList;
import java.util.List;

public class GenSet<E> {
    private E a[];

    public GenSet() {
//        a = new E[10]; // error: generic array creation
//        List<Integer> arrayOfIntegerList[] = new ArrayList<Integer>[10];
        Object objectArray[] = new Integer[10];
//        List<Object> objectList = new ArrayList<Integer>();
    }

    public static void main(String[] args) {
        MyArrayList<String> myL = new MyArrayList();
        myL.add(0, "aaa");
        String e = myL.getE(0);
        System.out.println(e);


    }
}

class MyArrayList<E> {
    Object[] cap = new Object[10];

    public void add(int index, E e) {
        cap[index] = e;
    }

    @SuppressWarnings("unchecked")
    public E[] getAll() {
        return (E[]) cap;
    }

    @SuppressWarnings("unchecked")
    public E getE(int index) {
        return (E) cap[index];
    }

}