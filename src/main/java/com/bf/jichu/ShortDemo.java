package com.bf.jichu;

/**
 * @description:
 * @author: bofei
 * @date: 2020-06-30 09:57
 **/
public class ShortDemo {
    public static void main(String[] args) {
        short s1 = 1;
//        s1 = s1 + 1; // provided int ,required short  java 加减是int 操作(自动转换成int类型)
//        那s1是short ，不是int ，小的转大的 直接操作，不用强转，  大的转小的 要强转
        s1 += 1; // += 自动转型

        Short s22 = null;
        short s = s22; // 空指针

    }
}
