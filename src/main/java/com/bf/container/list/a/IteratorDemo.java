package com.bf.container.list.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @description:
 * @author: bofei
 * @date: 2020-07-08 11:13
 **/
public class IteratorDemo {

    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList(){{
            add(11);
            add(22);
            add(13);
        }};
        // 1 foreach会在编译期被优化为Iterator调用
        for (Integer integer : list) {
//            if (11 == integer) { // 11 报错， 22 不报错
                list.remove(integer);
//            }
        }
        // 2
/*        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
//            if (11 == next) {
                list.remove(next);
//                list.add(4);
//            }
        }*/

        // 3
/*        for (int i = 0; i < list.size(); i++) {
//            if (11 == list.get(i)) {
                list.remove(list.get(i));
//            }
        }*/

 /*       // 4 用了ArrayList中迭代器Itr的remove()而不是用ArrayList本身的remove()
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }*/

        System.out.println(list);
    }
}
