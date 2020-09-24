package com.bf.util.date;


import org.apache.commons.lang3.math.NumberUtils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @description:
 * @author: bofei
 * @date: 2019-11-06 14:04
 **/
public class TestStringUtils {
    public static void main(String[] args) {
        String[] split = ",".split(",");
        System.out.println(Arrays.toString(split));
        for (String s : split) {
            System.out.println(s);
        }
        System.out.println(1);
    }

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static void main2(String[] args) throws IntrospectionException {

        boolean a = NumberUtils.isCreatable("-1.0");
        boolean b = NumberUtils.isCreatable("a");
        boolean c = Double.valueOf("1.0").equals(Double.valueOf("1"));
        System.out.println(a);
        System.out.println(c);



    }

    public static void test() throws IntrospectionException {
        PropertyDescriptor pd = new PropertyDescriptor("username", TestStringUtils.class);

        Method readMethod = pd.getReadMethod();
//        Object o1 = readMethod.invoke("");


    }
}
