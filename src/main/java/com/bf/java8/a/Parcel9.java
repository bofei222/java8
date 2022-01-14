package com.bf.java8.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author bofei
 * @Date 2019/7/7 13:22
 * @Description 实现类 、 匿名内部类 、 lambda 表达式
 */
class DesImp implements Destination {
    @Override
    public String readLabel() {
        return "11";
    }
}

public class Parcel9 {

    public String test(Destination destination) {
        return destination.readLabel() + "a";
    }

    public static void main(String[] args) {


        Parcel9 p = new Parcel9();


        DesImp desImp = new DesImp();
        String s = p.test(desImp);
        System.out.println(s);

        String s2 = p.test(new Destination() {
            @Override
            public String readLabel() {
                return "22";
            }
        });

        System.out.println(s2);

        String s3 = p.test(() -> {
                    return "33";
                }
        );
        System.out.println(s3);
    }
}
