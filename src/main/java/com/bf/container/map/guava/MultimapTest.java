package com.bf.container.map.guava;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import org.junit.Test;
import org.springframework.util.MultiValueMap;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;


/**
 * ,Map是一个key、value类型的键值对集合，集合中key不可以重复，但value可以重复
 *
 * 如果我们想在Map集合中存入一个相同的key，不同的value值得时候就必须使用Map<Integer,List<Object>>模式来存数据
 */
public class MultimapTest {

    @Test
    public void test1() {
        Multimap<Integer, Integer> map = HashMultimap.<Integer, Integer>create();

        map.put(1, 2);
        map.put(1, 2);
        map.put(1, 3);
        map.put(1, 4);
        map.put(2, 3);
        map.put(3, 3);
        map.put(4, 3);
        map.put(5, 3);
        System.out.println(map);


        //判断集合中是否存在key-value为指定值得元素
        System.out.println(map.containsEntry(1, 2));
        System.out.println(map.containsEntry(1, 6));
        //获取key为1的value集合
        Collection<Integer> list = map.get(1);
        System.out.println(list);

        //返回集合中所有key的集合，重复的key将会用key * num的方式来表示
        Multiset<Integer> set = map.keys();
        System.out.println(set);

        //返回集合中所有不重复的key的集合
        Set<Integer> kset = map.keySet();
        System.out.println(kset);
    }

    @Test
    public void test2() {
        Multimap<Integer, Integer> map = HashMultimap.<Integer, Integer>create();

        map.put(1, 2);
        map.put(1, 2);
        map.put(1, 3);
        map.put(1, 4);
        map.put(2, 3);
        map.put(3, 3);
        map.put(4, 3);
        map.put(5, 3);
        System.out.println(map);

        // replaceValues方法会替换掉key的value值，并且返回之前对应的值
        Collection<Integer> coll = map.replaceValues(1, Arrays.asList(1,7,8,9,10));
        System.out.println(coll);
        System.out.println(map);

    }
}
