package com.bf.container;

import java.util.HashMap;

public class MyMap<K, V> {

    Entry[] arr = new Entry[999];
    int size;

    public void put(K k, V v) {
        Entry<K, V> e = new Entry<>(k, v);
        arr[size++] = e;

    }

    public V get(K k) {
        for (int i = 0; i < size; i++) {
            if (arr[i].k.equals(k)) {
                return (V) arr[i].v;
            }
        }
        return null;
    }

    public boolean containsKey(K k) {

        return false;
    }

    private class Entry<K,V> {
        private K k;
        private V v;

        public Entry(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }


    public static void main(String[] args) {
        HashMap hashMap = new HashMap<String,Wife>();
        hashMap.put("bf", new Wife("nyy"));
        hashMap.put("bf2", new Wife("凛"));
        hashMap.put("bf3", new Wife("蕾姆"));

//        System.out.println(hashMap.get("bf2"));
//        System.out.println(hashMap.containsKey("bf3"));
//        System.out.println(hashMap.containsValue("蕾姆"));

        MyMap<String, Wife> myMap = new MyMap<>();
        myMap.put("bf1", new Wife("樱"));
        System.out.println(myMap.get("bf1"));
    }
}

class Wife{
    String name;

    public Wife(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}