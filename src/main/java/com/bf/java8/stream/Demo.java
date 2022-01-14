package com.bf.java8.stream;

import java.util.function.Supplier;

/**
 * @description: Demo01
 * @author: bofei
 * @date: 2019-11-22 13:47
 **/
public class Demo {
    public static void bo(MyFunctionInterface myFunctionInterface) {
        myFunctionInterface.fei();
    }

    public static String getString(Supplier<String> a) {
        return a.get();
    }

    public static Integer getMax(Supplier<Integer> a) {
        return a.get();
    }

    public static void main(String[] args) {
        bo(()->System.out.println("我执行了"));

        System.out.println(getString(() -> {return "a" + "b";}));;

        Integer max1 = getMax(() -> {
            int arr[] = {1, 2, 3, 4,};
            int max = arr[0];
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > max) max = arr[i];
            }
            return max;
        });
        System.out.println(max1
        );
    }
}

@FunctionalInterface
interface MyFunctionInterface {
    void fei();
}
