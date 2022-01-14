package com.bf.container.sort;

import java.util.Arrays;

public class Bubble1Sort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 4, 6};
        System.out.println("------------");
//        System.out.println(sort(arr));
        sort(arr);
//        arr = new int[]{1, 2};
//        System.out.println(Arrays.toString(sortFirst(arr)));
    }

    public static int[] sort(int[] arr) {
        for (int j = 0; j < arr.length -1 ; j++) {
            for (int i = 0; i < arr.length -1 - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
                System.out.println(Arrays.toString(arr));
            }
        }
        return arr;
    }

}
