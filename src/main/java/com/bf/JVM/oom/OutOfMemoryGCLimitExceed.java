package com.bf.JVM.oom;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @description:
 * @author: bofei
 * @date: 2020-06-11 14:39
 **/
public class OutOfMemoryGCLimitExceed {

    public static void addRandomDataToMap() {
        Map<Integer, String> dataMap = new HashMap<>();
        Random r = new Random();
        while (true) {
            dataMap.put(r.nextInt(), String.valueOf(r.nextInt()));
        }
    }

    public static void main(String[] args) {
        addRandomDataToMap();
    }
}
