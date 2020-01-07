package com.bf;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description: 处理List<Map>数据
 * @author: bofei
 * @date: 2019-12-03 14:12
 **/
public class Test2 {



    /**
     * @description column 值要转为列的key， dim 作为维度、行数的key
     * @param [column, dim, mapBigList]
     * @return java.util.List<java.util.Map>
     * @author bofei
     * @date 2019/12/31 10:43
     */
    public static List<Map> row2Column(String column, String dim, List<Map> mapBigList) {
        List<Map> mapList = new ArrayList<>();
        Map<Object, List<Map>> mapByGroup = mapBigList.stream().collect(Collectors.groupingBy(e -> e.get(dim),LinkedHashMap::new, Collectors.toList()));
//        System.out.println("timePint" + timePoint);

        Set<Object> keys = mapByGroup.keySet();
        for (Object key : keys) {
            if (!dim.equals(key)) {
                Map target = new LinkedHashMap(); // map的个数
                target.put(dim, key);
                List<Map> maps = mapByGroup.get(key);
                for (Map map : maps) {
                    // 非timePoint的 key的个数
                    target.put(map.get(column), map.get("indexVal") == null ? "" : map.get("indexVale"));
                }
                mapList.add(target);
            }
        }
        return mapList;
    }

    public static List<Map> column2Row(String column, String dim, List<Map> mapList) {
        List<Map> mapBigList = new ArrayList<>();
        for (Map map : mapList) {
            Set set = map.keySet();
            // 大List map个数 = 原个数*非timePoint的Key个数
            for (Object key : set) {
                if (!dim.equals(key)) {
                    Map target = new LinkedHashMap();
                    target.put(dim, map.get(dim));
                    target.put(column, key);
                    target.put("indexVal", map.get(key));
                    mapBigList.add(target);
                }
            }
        }
        return mapBigList;
    }


    // 指标在列
    public static List<Map> b2A(List<Map> mapList) {
        return column2Row("indexCode", "timePoint", mapList);
    }

    // 时点在列
    public static List<Map> d2A(List<Map> mapList) {
        return column2Row("timePoint", "indexCode", mapList);
    }

    // 原个数 = timePoint组的个数
    public static List<Map> a2B(List<Map> mapBigList) {
        return row2Column("indexCode", "timePoint", mapBigList);
    }

    public static List<Map> a2D(List<Map> mapBigList) {
        return row2Column("timePoint", "indexCode", mapBigList);
    }




    public static void main(String[] args) {

        List<List> list = new ArrayList<>();
        list.add(new ArrayList(Arrays.asList("timePoint", "P0000035", "P0000036")));
        list.add(new ArrayList(Arrays.asList("0:00", "111", "222")));
        list.add(new ArrayList(Arrays.asList("0:15", "333", "444")));

//        System.out.println(list);
        List<Map> c2B = c2B(list);
        System.out.println("c2B" + c2B);

        List<Map> b2A = b2A(c2B);
        System.out.println("b2A" + b2A);

        List<Map> a2B = a2B(b2A);
        System.out.println("a2B" + a2B);


        List<Map> a2D = a2D(b2A);
        System.out.println("a2D" + a2D);
        List<Map> d2A = d2A(a2D);
        System.out.println("d2A" + d2A);

//        List<List> lists = b2C(a2B);
//        System.out.println(lists);

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
                Map map = new LinkedHashMap();
                List valueList = list.get(i);
                for (int j = 0; j < valueList.size(); j++) {
                    map.put(keyList.get(j), valueList.get(j));
                }
                mapList.add(map);
            }
        }
        return mapList;
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
