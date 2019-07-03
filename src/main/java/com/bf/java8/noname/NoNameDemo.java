package com.bf.java8.noname;

/**
 * Created by bofei on 18-6-20.
 * 匿名内部类 核心：需要一个fun()
 * 面向对象编程要求的太严谨了，所以引入了函数式编程
 */

/**
 * 1.（参数）-> 单行语句
 */
interface IMessage {
//    void print(String s);
    int add(int x, int y);
}
public class NoNameDemo {
    public static void main(String[] args) {
        fun(new NameDemo()); // 1.实现类

        fun(new IMessage() {
            @Override
            public int add(int x, int y) {
                return x + y;
            }
        }); // 2.匿名内部类

        fun((x, y) -> x + y);// 3.Lambda，匿名函数 （只有一个表达式，不用写 return）
    }
    private static class NameDemo implements IMessage {
        @Override
        public int add(int x, int y) {
            return x + y;
        }
    }
    public static void fun(IMessage msg) {
//        msg.print("Hello World!");
        System.out.println(msg.add(10, 20));
    }
}
