package com.bf.algs;

import com.bf.container.map.a.ArrayListDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: bofei
 * @date: 2020-06-18 16:41
 **/
public class ListSub {
    public static void main(String[] args) {
        List entityList = new ArrayList();
        for (int i = 0; i < 406; i++) {
            entityList.add(i);
        }

        List target = new ArrayList();
        int i = 0;
        int l = entityList.size();
        while (l > 100) {

            target.addAll(entityList.subList(i, i+100));
            i = i + 100;
            l = l - i;
        }
        target.addAll(entityList.subList(i, entityList.size()));

        System.out.println(target);
        System.out.println(entityList.equals(target));

        /*for (int i1 = 0; i1 < entityList.size(); i1++) {
            if (target.get(i1) != entityList.get(i1)) {
                System.out.println(target.get(i1));
            }
        }*/
    }

}
