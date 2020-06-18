package com.bf.container.set;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author bofei
 * @Date 2019/4/10 18:25
 * @Description
 */
public class Test_treeset {
    public static void main(String[] args) {


        /*public TreeSet()public TreeSet()
        构造一个新的空 set，该 set 根据其元素的自然顺序进行排序。
        *插入该 set 的所有元素都必须实现 Comparable 接口。
        所有这些元素都必须是可互相比较的：*/

        // 如果 不 显示 会报错 ：ClassCastException: com.bf.container.set.Teacher cannot be cast to java.lang.Comparable
        Set<Teacher> ts = new TreeSet<Teacher>();
        ts.add(new Teacher("zhangsan", 1));
        ts.add(new Teacher("lisi", 3));
        ts.add(new Teacher("wangmazi", 2));
        ts.add(new Teacher("wangwu",4));
        ts.add(new Teacher("mazi", 3));
        System.out.println(ts);
        Iterator<Teacher> it = ts.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
class Teacher   {
    int num;
    String name;

    Teacher(String name, int num) {
        this.num = num;
        this.name = name;
    }

    public String toString() {
        return "学号：" + num + "\t\t姓名：" + name;
    }

    //o中存放时的红黑二叉树中的节点，从根节点开始比较
    public int compareTo(Object o) {
        Teacher ss = (Teacher) o;
        //int result = num < ss.num ? 1 : (num == ss.num ? 0 : -1);//降序
        int result = num > ss.num ? 1 : (num == ss.num ? 0 : -1);//升序
        if (result == 0) {
            result = name.compareTo(ss.name);
        }
        return result;
    }
}