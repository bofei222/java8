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
        List<Map> mapList = listOfList2ListOfMap(list);


        List<Map> mapBigList = listOfMap2BigListOfMap(mapList);
        System.out.println(mapBigList);
        List<Map> maps = bigListOfMap2ListOfMap(mapBigList);
        System.out.println(maps);

    }

    public static List<Map> listOfMap2BigListOfMap(List<Map> mapList) {
        List<Map> mapBigList = new ArrayList<>();
        for (Map map : mapList) {
            Set set = map.keySet();
            // 大List map个数 = 原个数*非timePoint的Key个数
            for (Object key : set) {
                if (!"timePoint".equals(key)) {
                    Map target = new HashMap();
                    target.put("indexCode", key);
                    target.put("indexVal", map.get(key));
                    target.put("timePoint", map.get("timePoint"));
                    mapBigList.add(target);
                }
            }
        }
        return mapBigList;
    }

    // 原个数 = 大List map个数/2
    public static List<Map> bigListOfMap2ListOfMap(List<Map> mapBigList) {
        List<Map> mapList = new ArrayList<>();
        for (Map map : mapBigList) {
            Map target = new HashMap();
            target.put("timePoint", map.get("timePoint"));
            target.put(map.get("indexCode"), map.get("indexVal"));
            mapList.add(target);
        }
        return mapList;
    }


    public static List<Map> listOfList2ListOfMap(List<List> list) {
        List<Map> mapList = new ArrayList<>();

        List keyList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {

            keyList = list.get(0);
        }
        for (int i = 0; i < list.size(); i++) {
            if (i != 0) {
                Map map = new HashMap();
                List valueList = list.get(i);
                for (int j = 0; j < valueList.size(); j++) {
                    map.put(keyList.get(j), valueList.get(j));
                }
                mapList.add(map);
            }
        }
        System.out.println(mapList);
        return mapList;
    }
}
