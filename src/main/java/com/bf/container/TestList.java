package com.bf.container;

import java.util.ArrayList;

/**
 * @Author bofei
 * @Date 2019/6/5 15:59
 * @Description
 */
public class TestList {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        int i = 0;
        while (true) {

            list.add(i++);
            System.out.println(list.size());
            list.clear();

        }


    }
}
