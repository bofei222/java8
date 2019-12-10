package com.bf.algs.a;

import java.util.*;

class Person {
    private Integer id;
    private String name;
    private String adress;


    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Integer getId() {
        return id;
    }

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person(Integer id, String name, String adress) {
        this.id = id;
        this.name = name;
        this.adress = adress;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }
}

public class TestCompareList {
    public static void main(String[] args) {
        List<Person> list1 = new ArrayList<Person>();
        List<Person> list2 = new ArrayList<Person>();

//        Person a = new Person(1, "a", "北京");
//        Person a2 = new Person(1, "a", "上海");
//        Person b = new Person(2, "b");
//        list1.add(a);
//        boolean contains = list1.contains(a2);
//        System.out.println(contains);

        for (int i = 0; i < 30000; i++) {

//            list1.add("test" + i);
            list1.add(new Person(i, "bofei" + i));
        }
        for (int i = 0; i < 80000; i++) {
            list2.add(new Person(i, "bofei" + i));
//            list2.add("test" + i * 2);
        }

        getDiffrent1(list1, list2);
        getDiffrent2(list1, list2);
        getDiffrent3(list1, list2);
//        List<Person> diffrent4 = getDiffrent4(list1, list2);
//        System.out.println(diffrent4.size());
    }

    // 方法1，两层遍历查找，遍历次数为list1.size()*list2.size()，有点蠢
    private static List<Person> getDiffrent1(List<Person> list1, List<Person> list2) {
        // diff 存放不同的元素
        List<Person> diff = new ArrayList<Person>();

        // 开始查找的时间，用于计时
        long start = System.currentTimeMillis();
        for (Person str : list1) {
            if (!list2.contains(str)) {
                diff.add(str);
            }
        }
        // 计时
        System.out.println("方法1 耗时：" + (System.currentTimeMillis() - start) + " 毫秒");
        return diff;
    }



    // 方法2，两层遍历查找，用retainAll()方法查找，也很蠢，方法底层依旧是两层遍历
    private static List<Person> getDiffrent2(List<Person> list1, List<Person> list2) {
        long start = System.currentTimeMillis();
        list1.retainAll(list2);// 返回值是boolean
        System.out.println("方法2 耗时：" + (System.currentTimeMillis() - start) + " 毫秒");
        return list1;
    }

    // 方法3，用Map存放List1和List2的元素作为key，value为其在List1和List2中出现的次数
    // 出现次数为1的即为不同元素，查找次数为list1.size() + list2.size()，较方法1和2，是极大简化
    private static List<Person> getDiffrent3(List<Person> list1, List<Person> list2) {
        List<Person> diff = new ArrayList<Person>();
        long start = System.currentTimeMillis();
        Map<Person, Integer> map = new HashMap<Person, Integer>(list1.size() + list2.size());
        // 将List1元素放入Map，计数1
        for (Person Person : list1) {
            map.put(Person, 1);
        }
        // 遍历List2，在Map中查找List2的元素，找到则计数+1；未找到则放入map，计数1
        for (Person Person : list2) {
            Integer count = map.get(Person);
            if (count != null) {
                map.put(Person, ++count);// 此处可优化，减少put次数，即为方法4
                continue;
            }
            map.put(Person, 1);
        }
        for (Map.Entry<Person, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                diff.add(entry.getKey());
            }
        }
        System.out.println("方法3 耗时：" + (System.currentTimeMillis() - start) + " 毫秒");
        return diff;
    }

    // 优化方法3，减少put次数
    private static List<Person> getDiffrent4(List<Person> list1, List<Person> list2) {
        List<Person> diff = new ArrayList<Person>();
        long start = System.currentTimeMillis();
        Map<Person, Integer> map = new HashMap<Person, Integer>(list1.size() + list2.size());

        List<Person> maxList = list1;
        List<Person> minList = list2;
        if (list2.size() > list1.size()) {
            maxList = list2;
            minList = list1;
        }
        for (Person Person : maxList) {
            map.put(Person, 1);
        }
        for (Person Person : minList) {
            Integer count = map.get(Person);
            if (count != null) {
                map.put(Person, ++count);
                continue;
            }
            map.put(Person, 1);
        }
        for (Map.Entry<Person, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                diff.add(entry.getKey());
            }
        }
        System.out.println("方法4 耗时：" + (System.currentTimeMillis() - start) + " 毫秒");
        return diff;

    }

}
