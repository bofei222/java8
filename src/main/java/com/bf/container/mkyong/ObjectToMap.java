package com.bf.container.mkyong;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.Map;

/**
 * @description:
 * @author: bofei
 * @date: 2020-01-16 13:50
 **/
public class ObjectToMap {
    public static void main(String[] args) {

        ObjectMapper oMapper = new ObjectMapper();

        Student obj = new Student();
        obj.setName("mkyong");
        obj.setAge(34);
        obj.setSkills(Arrays.asList("java","node"));

        // object -> Map
        Map map = oMapper.convertValue(obj, Map.class);
        System.out.println(map);

    }
}
