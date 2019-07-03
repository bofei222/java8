package com.bf.algs;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author bofei
 * @Date 2019/4/4 13:26
 * @Description
 */
public class TowNumSum {
    public static void main(String[] args) {
        int[] array1 = new int[40000];
        for (int i = 0; i < 40000; i++) {
            array1[i] = i - 10000;
        }

        execute0(array1);
        execute1(array1);
    }

    public static void execute0(int[] arr) {
        long start = System.currentTimeMillis();
        Map map = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            for (int i1 = 0; i1 < arr.length; i1++) {
                if (0 - arr[i] == arr[i1]) {
//                    System.out.println("ok0: " + arr[i1]);
                    map.put(arr[i], arr[i1]);
                }
            }
        }
        System.out.println("execute0: " + (System.currentTimeMillis() - start));
    }

    public static void execute1(int[] arr) {
        Map map1 = new HashMap();
        long start = System.currentTimeMillis();
        HashMap<Integer, Object> map = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], "1");
        }
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(0 - arr[i])) {
//                System.out.println("ok: " + arr[i]);
                map.put(arr[i], -arr[i]);
            }
        }
        System.out.println("execute1: " + (System.currentTimeMillis() - start));
    }

}
