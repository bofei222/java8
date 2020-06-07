package com.bf.JUC.syncmain;

public class SyncMain {

}


class Parent {
    public synchronized void method() { }
}
class Child extends Parent {
    public synchronized void method() { }
}


class Parent2 {
    public synchronized void method() {   }
}
class Child2 extends Parent2 {
    public void method() { super.method();   }
}