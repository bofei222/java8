package com.bf.net.tcp.listener;

/**
 * @description:
 * @author: bofei
 * @date: 2021-04-22 10:22
 **/
public interface PersonListener {
    void doEat(Event event);

    void doSleep(Event event);
}

class ListenerImpl implements PersonListener {
    @Override
    public void doEat(Event event) {
        Person person1 = event.getResource();
        System.out.println(person1 + "开始执行eat！");
    }

    @Override
    public void doSleep(Event event) {
        Person person1 = event.getResource();
        System.out.println(person1 + "开始执行sleep！");
    }
}
/**
 * 事件源Person
 * <p>
 * 事件源要提供方法注册监听器(即在事件源上关联监听器对象)
 */

class Person {

    //在成员变量定义一个监听器对象
    private PersonListener personListener;

    //在事件源中定义两个方法
    public void Eat() {
        //当事件源调用了Eat方法时，应该触发监听器的方法，调用监听器的方法并把事件对象传递进去

        // 创建一个事件
        Event event = init();
        // 触发事件
        start(event);
    }

    public void start(Event event) {
        personListener.doEat(event);
    }

    public Event init() {
        return new Event(this);
    }

    public void sleep() {
        //当事件源调用了Eat方法时，应该触发监听器的方法，调用监听器的方法并把事件对象传递进去
        personListener.doSleep(new Event(this));
    }

    //注册监听器，该类没有监听器对象啊，那么就传递进来吧。
    public void registerLister(PersonListener personListener) {
        this.personListener = personListener;
    }



}


/**
 * 事件对象Even
 * <p>
 * 事件对象封装了事件源
 * <p>
 * 在监听器上能够通过事件对象获取得到事件源
 */
class Event {
    private Person person;

    public Event() {
    }

    public Event(Person person) {
        this.person = person;
    }

    public Person getResource() {
        return person;
    }
}