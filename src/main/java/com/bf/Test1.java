package com.bf;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description: 处理List<Map>数据
 * @author: bofei
 * @date: 2019-12-03 14:12
 **/
public class Test1 {


    public static List<Map> b2A(List<Map> mapList) {
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

    // 原个数 = timePoint组的个数
    public static List<Map> a2B(List<Map> mapBigList) {
        List<Map> mapList = new ArrayList<>();
        Map<Object, List<Map>> timePoint = mapBigList.stream().collect(Collectors.groupingBy(e -> e.get("timePoint")));
//        System.out.println("timePint" + timePoint);

        Set<Object> keys = timePoint.keySet();
        for (Object key : keys) {
            if (!"timePoint".equals(key)) {
                Map target = new HashMap(); // map的个数
                target.put("timePoint", key);
                List<Map> maps = timePoint.get(key);
                for (Map map : maps) {
                    // 非timePoint的 key的个数
                    target.put(map.get("indexCode"), map.get("indexVal"));
                }
                mapList.add(target);
            }
        }
        return mapList;
    }

    public static List<List> b2C(List<Map> mapList) {
        List<List> listList = new ArrayList<>();

        Map map = mapList.get(0);
        Set set = map.keySet();
        listList.add(new ArrayList(set)); // key作为第一行

        for (int i = 0; i < mapList.size(); i++) {
            List list = new ArrayList(mapList.get(i).values());
            listList.add(list);
        }
        return listList;
    }


    public static List<Map> c2B(List<List> list) {
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

    public static void main(String[] args) {

        List<List> list = new ArrayList<>();
        list.add(new ArrayList(Arrays.asList("timePoint", "P0000035", "P0000036")));
        list.add(new ArrayList(Arrays.asList("1", "111", "222")));
        list.add(new ArrayList(Arrays.asList("2", "333", "444")));

        System.out.println(list);
        List<Map> mapList = c2B(list);


        List<Map> mapBigList = b2A(mapList);
        System.out.println(mapBigList);
        List<Map> maps = a2B(mapBigList);
        System.out.println(maps);

        List<List> lists = b2C(maps);
        System.out.println(lists);

    }
}


/* 此 3种 数据格式 的转换
---------------------------A
[{
        "timePoint": 1,
        "indexCode": "P0000035",
        "indexVal": "111"
        },
        {
        "timePoint": 1,
        "indexCode": "P0000036"
        "indexVal": "222"
        },
        {
        "timePoint": 2,
        "indexCode": "P0000035"
        "indexVal": "333"
        }, {
        "timePoint": 2,
        "indexCode": "P0000036"
        "indexVal": "444"
        }
        ]
        --------------------------B
        [{
        "timePoint": 1,
        "P0000035": "111",
        "P0000036": "222",
        },
        {
        "timePoint": 2,
        "P0000035": "333",
        "P0000036": "444",
        }

        ]
        --------------------------C
        [
        ["timePoint","P0000035","P0000036"],
        ["1","111","222"],
        ["2","333","444"],
        ]
*/
