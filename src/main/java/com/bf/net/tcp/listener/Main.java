package com.bf.net.tcp.listener;

/**
 * @description:
 * @author: bofei
 * @date: 2021-04-22 10:24
 **/
public class Main {
    public static void main(String[] args) {

        Person person = new Person();

        //注册监听器()
        person.registerLister(new ListenerImpl());


        //当调用eat方法时，触发事件，将事件对象传递给监听器，最后监听器获得事件源，对事件源进行操作
        person.Eat();
    }
}
