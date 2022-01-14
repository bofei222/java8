package com.bf.reflection;


import com.bf.stringdemo.A;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> tableHeader = new ArrayList<>();
        List<String> tableBody = new ArrayList<>();

        // 获取pdf注解的属性
        Field[] declaredFields = User.class.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            MyPDF myPDFAnnotation = declaredField.getDeclaredAnnotation(MyPDF.class);

            if (null != myPDFAnnotation) {
//                System.out.println(myPDFAnnotation); // 自定义注解必须 有 作用域、作用周期
//                System.out.println(declaredField.getName());

                tableHeader.add(myPDFAnnotation.value());
                tableBody.add(declaredField.getName());
            }
        }
        System.out.println(tableHeader);
        System.out.println(tableBody);
    }
}
