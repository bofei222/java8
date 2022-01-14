package com.bf;

/**
 * @description:
 * @author: bofei
 * @date: 2019-12-02 18:19
 **/
public class SwtichTest {
    public static void main(String[] args) {
        int a = 2;
        switch (a) {
            case 1:
            case 2:
            case 3:
                System.out.println(2);
                break;
        }

        String key = "thermal_new_energy_price";
        String mark = key.substring(key.lastIndexOf('_') + 1);
        System.out.println(mark);
    }
}
