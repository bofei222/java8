package com.bf.container.map;

import java.util.HashMap;
import java.util.Map;

public class Test1 {
    public static void main(String[] args) {
        String str = "this is a cat and that is a mice and where is the food";
        String[] split = str.split(" ");
        System.out.println(split);
        Map<String,Letter> map = new HashMap<String,Letter>();
        for (String s :
                split) {
            if (map.containsKey(s)) {
                Letter letter = map.get(s);
                letter.setCount(letter.getCount() + 1);
            } else {
                map.put(s, new Letter(s, 1));
            }
        }
        System.out.println(map);


    }
}
