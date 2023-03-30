package com.bf.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: bofei
 * @date: 2022-12-15 10:27
 **/
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.test();
    }

    void test() {

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                loop();
            } catch (Exception e) {
                System.out.println(1111);
                throw new RuntimeException(e);
            }
        }
    }

    void loop() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.stream().forEach(x -> {
            try {
                System.out.println(x);
                send();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println(x);
        });
    }

    void send()  throws IOException{
        throw new IOException("send");
    }


}
