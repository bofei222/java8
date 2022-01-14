package com.bf.container.list;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: bofei
 * @date: 2019-12-25 16:56
 **/
public class TestRef {
    public static void main(String[] args) {
        List<A> list = new ArrayList<>(Arrays.asList(new A(-1), new A(-2), new A(-3)));
        test(list);
    }
    // aList aList1 指向的是一个位置
    public static void test(List<A> aList) {
        B b = new B();
        b.setAList(aList);
        List<A> aList1 = b.getAList();
        aList1.forEach(x->{
            x.a = -x.a;
        });
        System.out.println(aList1);
        System.out.println(aList);
        System.out.println(aList1 == aList);
        aList.forEach(x->{
            x.a = -x.a;
        });
        System.out.println("------------------------");
        System.out.println(aList);
        System.out.println(aList1);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class A {
    int a;


}

@Data
class B {
    List<A> aList;
}
