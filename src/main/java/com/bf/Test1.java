package com.bf;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description: 处理List<Map>数据
 * @author: bofei
 * @date: 2019-12-03 14:12
 **/
public class Test1 {
    public static void main(String[] args) {

        List<List> list = new ArrayList<>();
        list.add(new ArrayList(Arrays.asList("timePoint", "P0000035", "P0000036")));
        list.add(new ArrayList(Arrays.asList("1","111","222")));
        list.add(new ArrayList(Arrays.asList("2","333","444")));

        System.out.println(list);

//        List<Map> mapList = new ArrayList<>();
//        for (int i = 0; i < list.size(); i++) {
//            List keyList = list.get(0);
//
//        }





    }
}
