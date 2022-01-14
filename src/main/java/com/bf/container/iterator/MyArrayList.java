package com.bf.container.iterator;

public class MyArrayList {
    private String[] ele = {"a", "b", "c", "d", "e", "f", "g"};
    private int size = ele.length;

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

    public static void main(String[] args) {
        MyArrayList ml = new MyArrayList();
        while (ml.hasNext()) {
            System.out.println(ml.next());
        }
    }
}
