package com.bf.algs.c;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @author: bofei
 * @date: 2019-12-09 17:59
 **/
public class ListTest {
    public static void main(String[] args) {
        List<Ht> htList = new ArrayList<>(Arrays.asList(
                new Ht("1","合同1", "1"),
                new Ht("2","合同2", "2"),
                new Ht("3","合同3", "3"),
                new Ht("4","合同4", "4")));

        List<Customer> customerList = new ArrayList<>(Arrays.asList(
                new Customer("1","客户1"),
                new Customer("2","客户2"),
                new Customer("3","客户3")));

//        System.out.println(htList);
//        System.out.println(customerList);

        HashMap<String, Ht> htMap = new HashMap();
        for (Ht ht : htList) {
            htMap.put(ht.getCustomerId(), ht);
        }

        List<SettlementVO> list = new ArrayList<>();
        for (Customer customer : customerList) {
            if (htMap.containsKey(customer.getCustomerId())) {
                Ht ht = htMap.get(customer.getCustomerId());
                list.add(new SettlementVO(ht, customer));
            }
        }

        System.out.println(list);

        System.out.println("---------------------");

        // 方法一； m*n
        List<SettlementVO> list3 = new ArrayList<>();
        for (Ht ht : htList) {
            for (Customer customer : customerList) {
                if (ht.getCustomerId().equals(customer.getCustomerId())) {
                    list3.add(new SettlementVO(ht, customer));
                }
            }
        }
        System.out.println(list3);
        System.out.println(list3.size());
    }
}

@Data
class Ht {
    private String htId;
    private String htName;
    private String customerId;

    public Ht(String htId, String htName, String customerId) {
        this.htId = htId;
        this.htName = htName;
        this.customerId = customerId;
    }
}
@Data
class Customer {
    private String customerId;
    private String customerName;

    public Customer(String customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
    }
}
@Data
class Business {
    private String customerId;
    private String price;
}
@Data
class SettlementVO {
    private Ht ht;
    private Customer customer;

    public SettlementVO(Ht ht, Customer customer) {
        this.ht = ht;
        this.customer = customer;
    }
}
//class SettlementVO {
//    private String htId;
//    private String htName;
//    private String customerId;
//    private String customerName;
//}


