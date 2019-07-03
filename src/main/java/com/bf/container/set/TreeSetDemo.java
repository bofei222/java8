package com.bf.container.set;

import java.util.TreeSet;

/**
 * @Author bofei
 * @Date 2019/4/10 18:06
 * @Description
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        //String类型降序
        // creating a TreeSet
        TreeSet<String> treeStr = new TreeSet<String>();
        TreeSet<String> treeReverseStr= new TreeSet<String>();
        // adding in the tree set
        treeStr.add("a");
        treeStr.add("b");
        treeStr.add("c");
        treeStr.add("d");
        System.out.println(treeStr);
        // creating reverse set
        treeReverseStr = (TreeSet) treeStr.descendingSet();
        System.out.println(treeReverseStr);

        //Integer类型降序
        TreeSet<Integer> tree = new TreeSet<Integer>();
        TreeSet<Integer> treeReverse = new TreeSet<Integer>();
        tree.add(1);
        tree.add(13);
        tree.add(17);
        tree.add(2);

        System.out.println(tree);
        treeReverse = (TreeSet) tree.descendingSet();

        System.out.println(treeReverse);

    }
}
