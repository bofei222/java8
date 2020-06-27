package com.bf.reflection;

import io.swagger.annotations.ApiModelProperty;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 获取pdf注解的属性
        Field[] declaredFields = User.class.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            MyPDF myPDFAnnotation = declaredField.getDeclaredAnnotation(MyPDF.class);

            if (null != myPDFAnnotation) {
                System.out.println(myPDFAnnotation); // 自定义注解必须 有 作用域、作用周期
                System.out.println(declaredField.getName());
            }
        }
        System.out.println();
    }
}
