package com.bf.leetcode;

import java.util.Arrays;
import java.util.LinkedList;


public class Solution2 {
    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<Integer>(Arrays.asList(2, 4, 3));
        LinkedList<Integer> l2 = new LinkedList<Integer>(Arrays.asList(5, 6, 4));

        System.out.println(l1);
        System.out.println(l2);
        addTwoNumbers(l1, l2);
    }

    public static LinkedList addTwoNumbers(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        LinkedList<Integer> results = new LinkedList<>();
        int sum1 = 0;
        int sum2 = 0;
        int sum = 0;
        for (int i = 0; i < l1.size(); i++) {
            sum1 += l1.get(i) * Math.pow(10, i);

        }
        System.out.println(sum1);
        for (int j = 0; j < l2.size(); j++) {
            sum2 += l2.get(j) * Math.pow(10, j);

        }
        sum = sum1 + sum2;
        System.out.println(sum2);
        System.out.println(sum);
        System.out.println(String.valueOf(sum).length());
        char[] chars = String.valueOf(sum).toCharArray();
        for (char c :
                chars) {
            Integer integer = Integer.valueOf(String.valueOf(c));
            results.add(integer);
        }
        System.out.println(results);
        return results;
    }
}

