package com.bf.container.list;

import java.util.Random;
import java.util.Vector;

/**
 * @description:
 * @author: bofei
 * @date: 2019-09-06 10:42
 **/
public class RandomTeacher {
    private static String[] getRandomteachers(String[] teachers, int n) {
        Vector<String> vName = new Vector<String>();

        for (int i = 0; i < n; i++) {
            while (true) {
                Random random = new Random();

                int index = random.nextInt(teachers.length - 1);
                if (vName.contains(teachers[index]) == false) {
                    vName.add(teachers[index]);
                    break;
                }
            }
        }
        //1.
//		return vName.toArray(new String[1]);//以空数组作为参数

        //2.
//		String [] choosedTeacher = new String[3];//当空间不够用时，toArray(T[] a)会自动分配一个新的数组
//		vName.toArray(choosedTeacher);

        //3.姑且认为是最好的。
        return vName.toArray(new String[vName.size()]);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String teachers[] = { "张", "赵", "刘", "钱", "孙", "李", "周", "吴", "郑", "王" };
        String[] choosedTeachers = RandomTeacher.getRandomteachers(teachers, 5);
        for (int i = 0; i < choosedTeachers.length; i++)
            System.out.println("teacher " + (i + 1) + " : "+ choosedTeachers[i]);

    }

}

