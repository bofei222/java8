package com.bf.JVM;

import java.util.Map;
import java.util.Random;

/**
 * @Author bofei
 * @Date 2019/6/6 9:00
 * @Description
 */
public class Wrapper {
    public static void main(String args[]) throws Exception {
        Map map = System.getProperties();
        Random r = new Random();
        while (true) {
            map.put(r.nextInt(), "value");
        }
    }

}
