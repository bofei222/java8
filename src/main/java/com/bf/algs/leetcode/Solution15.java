package com.bf.algs.leetcode;

import java.util.*;

public class Solution15 {


    private static Set<List> listSet;

    public static void main(String[] args) {
        int nums[] = {-1, 0, 1, 2, -1, -4};
//        System.out.println(threeSum(nums));
        listSet = new HashSet<>();
        listSet.add(Arrays.asList(1, 2, 3));
        listSet.add(Arrays.asList(3, 2, 1));
        System.out.println(listSet);
        Set<Integer> integerSet = new HashSet<>();
        integerSet.add(1);
        integerSet.add(1);
        System.out.println(integerSet);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> l = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> l2 = new ArrayList<>();
                        l2.add(nums[i]);
                        l2.add(nums[j]);
                        l2.add(nums[k]);
                        l.add(l2);
                    }
                }

            }
        }
        return l;
    }

}
