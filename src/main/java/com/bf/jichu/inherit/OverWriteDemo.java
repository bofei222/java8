package com.bf.jichu.inherit;

public class OverWriteDemo {
    public static void main(String[] args) {

    }
}


class Super {
    public String test(Integer a) {
        return "1";
    }
}

class Sub extends Super{
    @Override
    public String test(Integer a) {
        return "1";
    }
}