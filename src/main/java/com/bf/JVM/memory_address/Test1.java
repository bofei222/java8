package com.bf.JVM.memory_address;

/**
 * @Author bofei
 * @Date 2019/4/9 11:16
 * @Description
 */
public class Test1 {
    public static void main(String[] args) throws Exception {
        Object o = new Object();
        int oldHash = o.hashCode();
        long oldAddress = Addresser.addressOf(o);

        System.out.println(o);

        for (int i = 0; i < 100; i++) {
            System.gc();
        }

        int newHash = o.hashCode();
        long newAddress = Addresser.addressOf(o);
        System.out.println(oldAddress);
        System.out.println(newAddress);
        System.out.println("----------------");
        System.out.println(oldHash);
        System.out.println(newHash);
        System.out.println(oldHash == newHash);
        System.out.println(o);
    }
}
