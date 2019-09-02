package com.bf.container;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author bofei
 * @Date 2019/6/5 15:59
 * @Description
 */
public class TestList {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        User u = new User();
        u.setGroupName("测试001");
        u.setEmployeeName("一级审批");
        User u2 = new User();
        u2.setGroupName("测试001");
        u2.setEmployeeName("德州电厂");
        User u3 = new User();
        u3.setGroupName("测试001");
//        "a".compareTo("b")
        u3.setEmployeeName("a");
        list.add(u);
        list.add(u2);
        list.add(u3);

//        saleManCustomerList.stream().filter(saleManCustomer1 -> StringUtils.isNotBlank(saleManCustomer1.getGroupName()) && StringUtils.isNotBlank(saleManCustomer1.getEmployeeName()))
//                .collect(Collectors.toList())
//                .sort(Comparator.comparing(SaleManCustomer::getGroupName).thenComparing(SaleManCustomer::getEmployeeName));
        list.sort(Comparator.comparing(User::getGroupName).thenComparing(User::getEmployeeName));
        Comparator<User> comparing = Comparator.comparing((User user) -> user.getGroupName());


        System.out.println(list);
    }
    public static void main2(String[] args) {
        List list = new ArrayList<>(89);
        list.add("1");

//        System.out.println(list.get(10));

        System.out.println(list.get(0));

        Integer[] arr = new Integer[20];
        System.out.println(arr[2]);
        System.out.println(arr.length);


//        ArrayList<Object> list = new ArrayList<>();
//        int i = 0;
//        while (true) {
//
//            list.add(i++);
//            System.out.println(list.size());
//            list.clear();
//
//        }


    }
}
