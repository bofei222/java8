package com.bf.stringdemo;

import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;

/**
 * @Author bofei
 * @Date 2019/7/11 16:13
 * @Description
 */
public class A {
    public static void main(String[] args) {
        String a = BigDecimal.ZERO.toString();
        System.out.println(a);
        int roundHalfUp = BigDecimal.ROUND_HALF_UP;
        System.out.println(roundHalfUp);
    }
    public static void main4(String[] args) {
        Double i = 1.0d / 0.0;
        double j = 0.0d / 0.0;
        if (i == null) {
            System.out.println("null");
        }
        if (i.isNaN()) {
            System.out.println("NaN");
        }
        if (i.isInfinite()) {
            System.out.println("Infinite");
        }
    }
    public static void main3(String[] args) {
        JSONObject jo = new JSONObject();
        String string = jo.getString("1");
        System.out.println(string);
        BigDecimal deal_price = new BigDecimal("");
        System.out.println(deal_price);
    }

    public static void main2(String[] args) {
        String s = subFileName("customer/customerTemp/20190711102323-测试附件1.xlsx|customer/customerTemp/20190711102323-企查查接口报价表V11.16.xlsx");
        System.out.println(s);
    }

    public static String subFileName(String paths) {
        StringBuffer sb = new StringBuffer();

        String[] pathArr = paths.split("|");
//        if (ArrayUtils.isNotEmpty(pathArr)) {
            for (String s : pathArr) {
                int i = s.indexOf("/", 1);
                String fileName = s.substring(i + 18);
                sb.append(fileName + "|");
            }
//        }
        String fileNames = sb.substring(0, sb.length() - 1);

        return fileNames;
    }
}
