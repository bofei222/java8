package com.bf;


import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * 获取两个List的不同元素（假设List自身不存在重复元素）
 * Created by syl on 2017/12/26 0026.
 */
public class TestCompareList3 {
    public static void main(String[] args) {
        List<JSONObject> list1 = new ArrayList<JSONObject>();
        List<JSONObject> list2 = new ArrayList<JSONObject>();
        JSONObject jo11 = new JSONObject();
        jo11.put("id", 1);
        jo11.put("name", "a");
        JSONObject jo12 = new JSONObject();
        jo12.put("id", 2);
        jo12.put("name", "b");
        JSONObject jo13 = new JSONObject();
        jo13.put("id", 3);
        jo13.put("name", "c");
        list1.add(jo11);
        list1.add(jo12);
        list1.add(jo13);

        JSONObject jo21 = new JSONObject();
        jo21.put("id", 2);
        jo21.put("name", "b");
        JSONObject jo22 = new JSONObject();
        jo22.put("id", 3);
        jo22.put("name", "c");
        JSONObject jo23 = new JSONObject();
        jo23.put("id", 4);
        jo23.put("name", "d");
        list2.add(jo21);
        list2.add(jo22);
        list2.add(jo23);


//        boolean contains = list1.contains(jo2);
////        System.out.println(contains);
//        for (int i = 0; i < 300000; i++) {
//            JSONObject jo = new JSONObject();
//            jo.put("id", i);
//            jo.put("name","a");
//            list1.add(jo);
//        }
//        for (int i = 0; i < 800000; i++) {
//            JSONObject jo = new JSONObject();
//            jo.put("id", i);
//            jo.put("name","a");
//            list2.add(jo);
////            list2.add("test" + i * 2);
//        }

//        getDiffrent1(list1, list2);
//        getDiffrent2(list1, list2);
        List<JSONObject> diffrent3 = getDiffrent3(list1, list2);

//        System.out.println(diffrent3.size());
        System.out.println(diffrent3);
//        getDiffrent4(list1, list2);
    }

    // 方法1，两层遍历查找，遍历次数为list1.size()*list2.size()，有点蠢
    private static List<JSONObject> getDiffrent1(List<JSONObject> list1, List<JSONObject> list2) {
        // diff 存放不同的元素
        List<JSONObject> diff = new ArrayList<JSONObject>();
        // 开始查找的时间，用于计时
        long start = System.currentTimeMillis();
        for (JSONObject str : list1) {
            if (!list2.contains(str)) {
                diff.add(str);
            }
        }
        // 计时
        System.out.println("方法1 耗时：" + (System.currentTimeMillis() - start) + " 毫秒");
        return diff;
    }

    // 方法2，两层遍历查找，用retainAll()方法查找，也很蠢，方法底层依旧是两层遍历
    private static List<JSONObject> getDiffrent2(List<JSONObject> list1, List<JSONObject> list2) {
        long start = System.currentTimeMillis();
        list1.retainAll(list2);// 返回值是boolean
        System.out.println("方法2 耗时：" + (System.currentTimeMillis() - start) + " 毫秒");
        return list1;
    }

    // 方法3，用Map存放List1和List2的元素作为key，value为其在List1和List2中出现的次数
    // 出现次数为1的即为不同元素，查找次数为list1.size() + list2.size()，较方法1和2，是极大简化
    private static List<JSONObject> getDiffrent3(List<JSONObject> list1, List<JSONObject> list2) {
        List<JSONObject> diff = new ArrayList<JSONObject>();
        long start = System.currentTimeMillis();
        Map<JSONObject, Integer> map = new LinkedHashMap<JSONObject, Integer>(list1.size() + list2.size());
        // 将List1元素放入Map，计数1
        for (JSONObject JSONObject : list1) {
            map.put(JSONObject, 1);
        }
        // 遍历List2，在Map中查找List2的元素，找到则计数+1；未找到则放入map，计数1
        for (JSONObject JSONObject : list2) {
            Integer count = map.get(JSONObject);
            if (count != null) {
                map.put(JSONObject, ++count);// 此处可优化，减少put次数，即为方法4
                continue;
            }
            JSONObject.put("name", JSONObject.getString("name") + "_新增");
            JSONObject.put("flag", "+++++++");

            map.put(JSONObject, 1);
        }
        for (Map.Entry<JSONObject, Integer> entry : map.entrySet()) {
            JSONObject jo = entry.getKey();
            if (entry.getValue() == 1) {
                if (jo.get("flag") == null) {
                    jo.put("flag", "-----");
                    jo.put("name", jo.getString("name") + "_删除");
                }
            }
            diff.add(jo);
        }
        System.out.println("方法3 耗时：" + (System.currentTimeMillis() - start) + " 毫秒");
        return diff;
    }

    // 优化方法3，减少put次数
    private static List<JSONObject> getDiffrent4(List<JSONObject> list1, List<JSONObject> list2) {
        List<JSONObject> diff = new ArrayList<JSONObject>();
        long start = System.currentTimeMillis();
        Map<JSONObject, Integer> map = new HashMap<JSONObject, Integer>(list1.size() + list2.size());
        List<JSONObject> maxList = list1;
        List<JSONObject> minList = list2;
        if (list2.size() > list1.size()) {
            maxList = list2;
            minList = list1;
        }
        for (JSONObject JSONObject : maxList) {
            map.put(JSONObject, 1);
        }
        for (JSONObject JSONObject : minList) {
            Integer count = map.get(JSONObject);
            if (count != null) {
                map.put(JSONObject, ++count);
                continue;
            }
            map.put(JSONObject, 1);
        }
        for (Map.Entry<JSONObject, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                diff.add(entry.getKey());
            }
        }
        System.out.println("方法4 耗时：" + (System.currentTimeMillis() - start) + " 毫秒");
        return diff;

    }

}

