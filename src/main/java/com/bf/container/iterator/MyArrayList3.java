package com.bf.container.iterator;

import java.util.Iterator;

public class MyArrayList3 implements Iterable<String> {
    private String[] ele = {"a", "b", "c", "d", "e", "f", "g"};
    private int size = ele.length;
    

    public Iterator<String> iterator() {
        return new Iterator<String>(){
            private int cursor = -1;

            public boolean hasNext() {
                return cursor + 1 < size;
            }

            public String next() {
                cursor++;
                return ele[cursor];
            }

            public void remove() {

            }
        };
    }


    public static void main(String[] args) {
        MyArrayList3 ml = new MyArrayList3();
        Iterator<String> it = ml.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("-------------");
        for (String temp :
                ml) {
            System.out.println(temp);
        }
    }
}
