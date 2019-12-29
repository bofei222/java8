package com.bf.design;

/**
 * @description:
 * @author: bofei
 * @date: 2019-12-26 13:54
 **/
public class Main {
    public static void main(String[] args) {
        new NutritionFacts(100, 20);

        // 当想carbon不为零，其他可选都为0
        // 但该列表中包含了要设置的所有参数 这个构造器调用通常需要许多你本不想设置的参数，但还是不得不为他们传递值
        // 原因 方法的参数是安装顺序来的
        new NutritionFacts(100, 20,0,0,0,111);
    }
}
