package com.bf.container.iterator;

class P {
    private int a = 1;
    public void test1() {
        System.out.println("P.test1");
    }

    public P() {
        System.out.println("P.P");
    }

    public P(int a) {
        System.out.println("P.P有参");
        this.a = a;
    }
}
class C extends P {
    public int b = 2;
    public C(int a) {
//        super();
        this(3, 4);
    }

    public C(int a, int b) {
//        super(a);
        this.b = b;
    }

    @Override
    public void test1() {
        super.test1();
        System.out.println("C.test1");

    }

    public void test2() {
        System.out.println("C.test2");
    }
}
class X {
    private int c = 3;

    public X() {
        this(4);
        System.out.println("X.X");
    }

    public X(int c) {
        this.c = c;
    }
}

public class Test {
    public static void main(String[] args) {
        P p = new C(1);
//        ((C) p).test2();
//        p.test2();
        P c = new C(2);
        ((C)c).b = 3;
        p.test1();
    }
}
