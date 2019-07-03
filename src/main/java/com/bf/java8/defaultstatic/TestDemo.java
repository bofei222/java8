package com.bf.java8.defaultstatic;

/**
 * Created by bofei on 18-6-20.
 * 1.技术产生原因、场景 2.掌握语法
 */
interface IMessage {
    void print();
    default void fun() {// ：一个接口已经有了1万个实现类 现在要加一个方法，所有的类实现都一样
        System.out.println("毁三观的方法");
    }
    static void get() {
        System.out.println("接口直接调用");
    }
}

class MessageImpl implements IMessage {

    @Override
    public void print() {
        System.out.println("Hello World");
    }
}
public class TestDemo {
    public static void main(String[] args) {
        IMessage msg = new MessageImpl();
        msg.fun();
        IMessage.get();
        TestDemo.get();

    }
    public static void get() {
        System.out.println("TestDemo--get()");
    }
}
