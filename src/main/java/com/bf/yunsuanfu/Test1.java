package com.bf.yunsuanfu;

/**
 * @description:  "12345" 转为 int ，不能用Integer.value.of()
 * @author: bofei
 * @date: 2019-09-20 14:58
 **/
public class Test1 {
    public static void main(String[] args) {
        int result = 0;

        String s = "12345";
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
//            int a = (int)chars[i];  // char 1  int 49

            int a = chars[i] - '0';  //  将一个字符 减一个 '0'  char to int
            System.out.println(a);
            result += a * Math.pow(10, (s.length() - i -1));
        }
        System.out.println(result);
    }

}
