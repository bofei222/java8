package com.bf.java8.geeksforgeeks.b;

import lombok.Data;

/**
 * @description:
 * @author: bofei
 * @date: 2019-12-13 14:11
 **/
@Data
public class Test {

    private int a = 0;
    private int b = 0;

    interface FuncInter0 {
        Test sort(Test tObj);
    }

    // operation is implemented using lambda expressions
    interface FuncInter1 {
        int operation(int a, int b);
    }

    // sayMessage() is implemented using lambda expressions
    // above
    interface FuncInter2 {
        void sayMessage(String message);
    }


    // Performs FuncInter1's operation on 'a' and 'b'
    private int operate(int a, int b, FuncInter1 fobj) {
        return fobj.operation(a, b);
    }

    private Test sort(FuncInter0 fobj) {
        return fobj.sort(this);
    }

    public static void main(String args[]) {
        // lambda expression for addition for two parameters
        // data type for x and y is optional.
        // This expression implements 'FuncInter1' interface
        FuncInter1 add = (int x, int y) -> x + y;

        // lambda expression multiplication for two parameters
        // This expression also implements 'FuncInter1' interface
        FuncInter1 multiply = (int x, int y) -> x * y;

        // Creating an object of Test to call operate using
        // different implementations using lambda Expressions


        Test tobj = new Test();
        tobj.setA(6);
        tobj.setB(3);


        FuncInter0 lambda = (t) -> {
            int tmp = t.getA();
            t.setA(t.getB());
            t.setB(tmp);
            return t;
        };
        tobj.sort(lambda); // 模仿 list.sort((a, b) -> b - a);
        // 对象 调用方法 参数是 lambda表达式， 在写一个 方法， 参数是此对象 像这样 (this，lambda)
        System.out.println("------------" + tobj);

        // Add two numbers using lambda expression
        System.out.println("Addition is " +
                tobj.operate(6, 3, add));

        // Multiply two numbers using lambda expression
        System.out.println("Multiplication is " +
                tobj.operate(6, 3, multiply));

        // lambda expression for single parameter
        // This expression implements 'FuncInter2' interface
        FuncInter2 fobj = message -> System.out.println("Hello "
                + message);
        fobj.sayMessage("Geek");
    }
}
