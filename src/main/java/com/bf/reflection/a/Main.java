package com.bf.reflection.a;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: bofei
 * @date: 2020-07-07 10:58
 **/
public class Main {
    public static void main(String[] args) {
        try {
            Method getId = User.class.getMethod("getId");
            User user = new User();
            user.id = 10;
            Object invoke = getId.invoke(user);
            System.out.println(invoke.toString());

            Method[] methods = User.class.getMethods();
            for (Method method : methods) {
                System.out.println(method.getName());
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
