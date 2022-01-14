package com.bf.java8.a;

import java.util.function.Function;

/**
 * @description: lambda表达式
 * @author: bofei
 * @date: 2019-09-06 14:19
 **/
public class UseFoo {
    public String add(String string, Foo foo) {
        return foo.method(string);
    }

    public String add(String string, Function<String, String> fn) {
        return fn.apply(string);
    }

    public static void main(String[] args) {
        UseFoo useFoo = new UseFoo();
        Foo foo = parameter -> parameter + " from lambda";
        String result = useFoo.add("Message ", foo);

        System.out.println(result);


        Function fn = parameter -> parameter + "from lambda";
        String result2 = useFoo.add("Message", fn);
        System.out.println(result2);

        Foo fooByIC = new Foo() {
            @Override
            public String method(String string) {
                return string + " from Foo";
            }
        };
        // 有点像匿名内部类
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
            }
        };
        Thread thread = new Thread(r);

        // 匿名内部类
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
            }
        });

        String result3 = useFoo.add("Message ", fooByIC);
        System.out.println(result3);
    }



}
