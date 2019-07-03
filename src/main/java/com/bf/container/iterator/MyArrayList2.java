package com.bf.container.iterator;

import java.util.Iterator;

public class MyArrayList2 {
    private String[] ele = {"a", "b", "c", "d", "e", "f", "g"};
    private int size = ele.length;


    private class MyIt implements Iterator<String> {
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
    }

    public Iterator<String> iterator() {
        return new MyIt();
    }


    public static void main(String[] args) {
        MyArrayList2 ml = new MyArrayList2();
        Iterator<String> it = ml.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
