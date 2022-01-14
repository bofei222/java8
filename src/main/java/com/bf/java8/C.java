package com.bf.java8;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @description:
 * @author: bofei
 * @date: 2019-11-22 17:22
 **/
public class C {

    int getH() { // 只要 方法签名对应山  F 就行， 就是 他的实现
        return 10;
    }

    int getJ() {
        return 10;
    }

    int getZ(int a) {
        return 20;
    }

    void setH() {
        System.out.println();
    }
    public static void main(String[] args) {
        C c = new C();
        System.out.println(getter(c1 -> 1
                , c));// 10



        System.out.println(getter(C::getJ, c));// 20



        F<C> getY = (a) -> {return 30;};  // lambda表达式 没有this

        int apply = getY.apply(c);
        System.out.println(apply);
//        System.out.println(getter(getY, c)); // 30

//        setter(C::setH, c);


    }


// 没有此方法也可以
    public static <T> int getter(F<T> f, T t) {
        return f.apply(t);
    }

    public static <T> void setter(Consumer<T> consumer, T t) {
        consumer.accept(t);
    }
}

@FunctionalInterface
interface F<T> {
    int apply(T t); // 这里没有隐含的this ，所有要有个参数 ，这样和getH()对应上
}

