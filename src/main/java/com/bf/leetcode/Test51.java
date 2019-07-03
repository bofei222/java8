package com.bf.leetcode;

/**
 * @Author bofei
 * @Date 2019/5/5 9:24
 * @Description
 */
public class Test51 {
    public static void main(String[] args) {
        int[] arr = {7, 5, 6, 4};
        Integer count = test(arr);
        System.out.println(count);
    }

    public static Integer test(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.println("i: " + i);
                System.out.println("j: " + j);
                System.out.println("-----------");
                if (arr[i] > arr[j]) {
                    sum += 1;
                }
            }
            System.out.println("=============");
        }

        return sum;
    }
}
