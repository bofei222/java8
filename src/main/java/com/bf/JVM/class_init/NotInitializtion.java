package com.bf.JVM.class_init;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * @Author bofei
 * @Date 2019/3/20 10:01
 * @Description 对于静态字段，只有直接定义这个字段的类才会被初始化
 * out:SuperClass init !
 *     123
 */
public class NotInitializtion {
//    static {
//        System.out.println("NotInitializtion init !");
//    }

    public static void main(String[] args) {
        Hashtable<Object, Object> ht = new Hashtable<>();
//        ht.put(null, 1);
        HashMap<Object, Object> hm = new HashMap<>();
        hm.put(null, null);

        System.out.println(SubClass.value);
    }
}
