package com.bf.algs.b;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @description:
 * @author: bofei
 * @date: 2019-12-09 19:37
 **/
public class Test {
    public static void main(String[] args) {
        List<Kh> list1 = new ArrayList<>(Arrays.asList(
                new Kh(1, "客户1"),
                new Kh(2, "客户2"),
                new Kh(3, "客户3"),
                new Kh(4, "客户4")));

        List<Ht> list2 = new ArrayList<>(Arrays.asList(
                new Ht(1, "合同1", 1),
                new Ht(2, "合同2", 2),
                new Ht(3, "合同3", 4)));


        // 方法二 m+n
        HashSet<Integer> hs = new HashSet<Integer>(list2.size());
        for (Ht o : list2) {
            hs.add(o.khId);
        }
        //hs contains all the ids of list2
        List<Kh> result = new ArrayList<Kh>(); //Or another class implementing List
        for (Kh o : list1) {
            if (hs.contains(o.id))
                result.add(o);
        }
        System.out.println(result);

        // 方法一 m*n
        List<Kh> result2 = new ArrayList<Kh>(); //Or another class implementing List
        for (Kh kh : list1) {
            for (Ht ht : list2) {
                if (kh.id == ht.khId) {
                    result2.add(kh);
                }
            }
        }
        System.out.println(result2);
    }
}


@Data
@AllArgsConstructor
class Kh {
    int id;
    String khName;
}

@Data
@AllArgsConstructor
class Ht {
    int htId;
    String name;
    int khId;
}