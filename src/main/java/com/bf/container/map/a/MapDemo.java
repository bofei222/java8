package com.bf.container.map.a;

import java.util.HashMap;

public class MapDemo {
    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put(1, "a");

        int i = tableSizeFor(17);
        System.out.println(i);




        int a = 1;
        a += 1; // a = a + 1;


        int n = 16;
        n |= n >>> 1; // n = n | (n >>> 1)

    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1; // n = n | (n >>> 1)
        n |= n >>> 2; // n = n | (n >>> 2)
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= (1 << 30)) ? (1 << 30) : n + 1;
    }
}
