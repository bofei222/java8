package com.bf.java8.funreference;

/**
 * Created by bofei on 18-6-20.
 *
 */
@FunctionalInterface
interface IMessage<R> {
    R upper();
//    int compare(P p1, P p2);
}

public class TestDemo {
    public static void main(String[] args) {
//        IMessage<Integer,String> msg = String::valueOf;
//        String s = msg.zhuanhuan(1000);

        /*IMessage<String> msg = "hello"::toUpperCase;
        String s = msg.upper();*/

        /*IMessage<String> msg = String::compareTo;
        System.out.println(msg.compare("A", "B"));// 将对象定义在了参数*/


//        IMessage r = new
//        System.out.println(s);
    }
}


