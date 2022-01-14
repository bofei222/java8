package com.bf.container;

import java.util.LinkedList;

public class MyMap2<K,V> {
    LinkedList[] arr = new LinkedList[999];
    int size;

    public void put(K key, V value) {
        Entry e = new Entry(key, value);
        int a = key.hashCode() % 999;
        if (arr[a] == null) {
            LinkedList<Entry<K,V>> list = new LinkedList<>();
            arr[a] = list;
            list.add(e);
        } else {
            arr[a].add(e);
        }
        size++;
    }

    public V get(K key) {
        int a = key.hashCode() % 999;
        if (arr[a] != null) {
            LinkedList<Entry<K,V>> list = arr[a];
            for (int i = 0; i < list.size(); i++) {
                Entry e = list.get(i);
                if (key.equals(e.key))
                    return (V) e.value;
            }
        }
        return null;
    }

    private class Entry<K,V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        MyMap2<String, Wife> myMap2 = new MyMap2<>();
        myMap2.put("b", new Wife("saber"));
        myMap2.put("a", new Wife("艾瑞莉娅"));
        System.out.println(myMap2.get("b"));
        System.out.println(myMap2.get("a"));
    }
}
