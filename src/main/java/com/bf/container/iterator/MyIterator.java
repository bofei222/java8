package com.bf.container.iterator;

import java.util.Iterator;

public class MyIterator<E> implements Iterator<E> {
    int cursor;

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public E next() {
        return null;
    }
}
