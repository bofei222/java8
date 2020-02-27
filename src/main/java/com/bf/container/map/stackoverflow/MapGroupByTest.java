package com.bf.container.map.stackoverflow;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description: List<Map> 按key分组 -》 Map<key,List<Map>
 *     按key分组 吗？ 不是，  是按key 的 值 是否相同来分组
 * @author: bofei
 * @date: 2020-01-20 10:49
 **/
public class MapGroupByTest {
    @Test
    public void test2() {

    }
    @Test
    public void test1() {
        Map<String, Integer> m1 = new HashMap<>();
        m1.put("A", 1);
        m1.put("B", 111);

        Map<String, Integer> m2 = new HashMap<>();
        m2.put("A", 10);
        m2.put("B", 222);

        Map<String, Integer> m3 = new HashMap<>();
        m3.put("A", 1);
        m3.put("B", 333);

        List<Map<String, Integer>> beforeFormatting = new ArrayList<>();
        beforeFormatting.add(m1);
        beforeFormatting.add(m2);
        beforeFormatting.add(m3);

        System.out.println(beforeFormatting);

        Map<Integer, List<Map<String, Integer>>> map = beforeFormatting.stream().collect(Collectors.groupingBy(
                stringIntegerMap -> stringIntegerMap.get("A")
        ));

        System.out.println(map);
    }
}
