package com.bf.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author: bofei
 * @date: 2022-03-03 08:20
 **/
public class Hot03 {

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring("abba"));
    }

    //len := lengthOfLongestSubstring0("abcabcbb") //
    //len := lengthOfLongestSubstring("ohomm") //
    //len := lengthOfLongestSubstring("dvdf") //
    //len := lengthOfLongestSubstring("abba") //
    //len := lengthOfLongestSubstring("pwwkew") //
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                start = Math.max(map.get(ch) + 1, start);
            }
            // max 取之前 和这次的最大 ，start 是出现重复时的 光标右移
            // max = 当前index - 起始光标  ，然后取 原值和这次的最大
            //
            max = Math.max(max, i - start + 1);
            map.put(ch, i);
        }
        return max;
    }


    public int lengthOfLongestSubstring0(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        System.out.println(occ);
        return ans;
    }
}

