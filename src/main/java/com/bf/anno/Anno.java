package com.bf.anno;

import java.lang.annotation.*;

/**
 * @description:
 * @author: bofei
 * @date: 2019-09-05 09:37
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Anno {
    /**
     * 若方法名为value且注解声明只需要声明value属性时，
     * value可以省略， @Anno("anno") 等同于 @Anno(value="anno")
     *
     * @return the string
     */
    String value();
    /**
     * 一个具有默认值的 String 类型属性。
     * name若不显式声明，则默认值为"" 。
     * 声明默认值通过 default + 默认值 来声明
     *
     * @return the string
     */
    String name() default "";
    /**
     * 一个Class 类型属性，没有默认值。其他支持类型不再举例
     *
     * @return the class
     */
//    Class<?> clazz();
}
