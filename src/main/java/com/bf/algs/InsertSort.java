package com.bf.algs;

import java.util.Arrays;

/**
 * @description:
 * @author: bofei
 * @date: 2019-11-05 09:53
 **/
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {6,5,4,3,2,1};
        int[] brr = sort(arr);
        System.out.println(Arrays.toString(brr));

    }
    public static int[] sort(int[] arr) {
        for (int j = 1; j < arr.length; j++) {
            int key = arr[j]; // key 临时字段 此次循环要保留的字段
            int i = j - 1;
            while (i >= 0 && arr[i] > key) {
                arr[i + 1] = arr[i];
                i = i - 1;
            }
            arr[i + 1] = key;
        }
        return arr;
    }
}
