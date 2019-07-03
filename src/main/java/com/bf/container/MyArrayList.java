package com.bf.container;

import java.util.ArrayList;
import java.util.List;

public class MyArrayList {

    private Object[] elementData;

    // 当前元素数量
    private int size;

    //
    private static final int DEFAULT_CAPACITY = 10;

    //
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    public MyArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public MyArrayList(int initialCapacity) {
        elementData = new Object[initialCapacity];
    }


    public void add(Object o) {
        if (size == elementData.length) {
            grow(size + 1);
        }
        elementData[size++] = o;
    }

    private void grow(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity <= 0) {
            if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA)
                newCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            newCapacity = Integer.MAX_VALUE;
        }
        Object[] newArr = new Object[newCapacity];
        System.arraycopy(elementData, 0, newArr, 0, size);
        elementData = newArr;
    }

    public Object get(Integer index) {
        rangeCheck(index);

        return elementData[index];
    }

    private void rangeCheck(Integer index) {
        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException(index);
    }

    public void remove(Integer index) {
        rangeCheck(index);
        int numMoved = size - index -1;
        if (numMoved > 0)
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        elementData[--size] = null;

    }

    public void remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (get(i).equals(o)) {
                remove(i);
            }
        }
    }

    public Object set(int index, Object o) {
        rangeCheck(index);
        Object oldElement = elementData[index];
        elementData[index] = o;
        return oldElement;
    }

    public static void main(String[] args) {
        List<Object> l = new ArrayList<>();
        l.add("aaa");
        l.add("aaa");
//        l.remove(1);
        l.set(1, "bbb");
        l.get(1);
        MyArrayList ml = new MyArrayList();
        ml.add(1);
        ml.add(2);
        ml.add(3);
        ml.add(4);
        ml.add(5);
        ml.add(6);
        System.out.println(ml.size);
        System.out.println(ml.get(6));


    }
}
