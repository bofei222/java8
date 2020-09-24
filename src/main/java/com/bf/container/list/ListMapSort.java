package com.bf.container.list;

import java.sql.Timestamp;
import java.util.*;
import java.util.function.Function;

/**
 * @description: List<Map> 按指定key（时间类型） 排序
 * @author: bofei
 * @date: 2020-08-15 14:59
 **/
public class ListMapSort {
    public static void main0(String[] args) {
        List<Map> mapList = new ArrayList<>();
        Map map = new HashMap<>();
        map.put("name", "a");
        map.put("time", new Date().getTime());

        Map map2 = new HashMap<>();
        map2.put("name", "b");
        map2.put("time", new Date().getTime() + 1);  // 转换为 毫秒数 Long 类型 比较

        mapList.add(map);
        mapList.add(map2);

        // Function<T,R> T 入参类型，R 出参 类型
        Function<Map,Long> function =(e) -> (Long) e.get("time");
        Comparator<Map> comparator = Comparator.comparing(function, new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                if (o1 > o2 ) return -1;
                else if (o1 < o2) return 1;
                else return 0;
            }
        });
        mapList.sort(comparator);
        System.out.println(mapList);

    }

    public static void main2(String[] args) {


        // 不加<Map> 则会报错， 不知道入参是Map， 不能调用get方法;
        Comparator<Map> comparator  = Comparator.comparing((e) -> (Long) e.get("time"), new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                if (o1 > o2 ) return -1;
                else if (o1 < o2) return 1;
                else return 0;
            }
        });
    }
    public static void main21(String[] args) {

        // 同样 不加(Long)  就不能指定 比较器的类型
        Comparator<Map> comparator = Comparator.comparing((e) -> e.get("time"), new Comparator<Object>() {

            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });
    }

    // o2 调用o1 好了
    public static void main23(String[] args) {

        // 不加<Map> 则会报错， 不知道入参是Map， 不能调用get方法;
        Comparator<Map> comparator  = Comparator.comparing((e) -> (Long) e.get("time"), (o1, o2) -> {
            return o2.compareTo(o1);
        });
    }

    // 最简化
    public static void main24(String[] args) {
        // 不加<Map> 则会报错， 不知道入参是Map， 不能调用get方法;
        Comparator<Map> comparator  = Comparator.comparing((e) -> (Long) e.get("time"), Comparator.reverseOrder());
    }

    // 不转换Long毫秒数
    public static void main01(String[] args) throws InterruptedException {
        System.out.println(new Date());
        List<Map> mapList = new ArrayList<>();
        Map map = new HashMap<>();
        map.put("name", "a");
        map.put("time", new Timestamp(new Date().getTime()));

        Thread.sleep(100);
        Map map2 = new HashMap<>();
        map2.put("name", "b");
        map2.put("time", new Timestamp(new Date().getTime()));
        mapList.add(map);
        mapList.add(map2);

        // Function<T,R> T 入参类型，R 出参 类型
        Function<Map,Timestamp> function =(e) -> (Timestamp) e.get("time");
        Comparator<Map> comparator = Comparator.comparing(function, (o1, o2) -> {
            if (o1.before(o2)) {
                return 1;
            } else if (o1.after(o2)) {
                return -1;
            } else {
                return 0;
            }

        });
        mapList.sort(comparator);
        System.out.println(mapList);
    }
    // TimeStamp  也可以用 Comparator.reverseOrder()!
    public static void main(String[] args) throws InterruptedException {
        System.out.println(new Date());
        List<Map> mapList = new ArrayList<>();
        Map map = new HashMap<>();
        map.put("name", "a");
        map.put("time", new Timestamp(new Date().getTime()));

        Thread.sleep(100);
        Map map2 = new HashMap<>();
        map2.put("name", "b");
        map2.put("time", new Timestamp(new Date().getTime()));
        mapList.add(map);
        mapList.add(map2);

        // Function<T,R> T 入参类型，R 出参 类型da
        Function<Map,Timestamp> function =(e) -> (Timestamp) e.get("time");
        Comparator<Map> comparator = Comparator.comparing(function, Comparator.reverseOrder());
        mapList.sort(comparator);
        System.out.println(mapList);
    }
}
