package com.bf.anno;

/**
 * @description:
 * @author: bofei
 * @date: 2019-09-05 09:38
 **/
@Anno(value = "hello", name = "bf")
public class Foo {}
/**
 * 通过获取Foo 的Class 类，
 * 然后就可以根据上面已经介绍的方法来获取value的值了
 * @author dax
 * @since 2019/9/4 22:17
 */
class Main {
    public static void main(String[] args) {
        Anno annotation = Foo.class.getAnnotation(Anno.class);
        String value = annotation.value();
        String name = annotation.name();
        System.out.println("name = " + name);
        System.out.println("value = " + value);
    }
}
