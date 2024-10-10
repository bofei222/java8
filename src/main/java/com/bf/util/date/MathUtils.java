package com.bf.util.date;


import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @description: 起动统一修改 统一判空的效果
 * @author: bofei
 * @date: 2019-10-23 08:46
 **/
public class MathUtils {
    public static void main(String[] args) {
        String s = null;
        String s2 = "";
        System.out.println(set2Scale(s));

        System.out.println(set2Scale(s2));


    }
    public static String setScaleFee(String originValue) {
        return new BigDecimal(originValue).setScale(4, RoundingMode.HALF_UP).toString();
    }
    public static String setScalePrice(String originValue) {
        return new BigDecimal(originValue).setScale(2, RoundingMode.HALF_UP).toString();
    }

    public static String set4Scale(String originValue) {
        if (null == originValue || "".equals(originValue)) return originValue;
        return new BigDecimal(originValue).setScale(4, RoundingMode.HALF_UP).toString();
    }

    public static String set2Scale(String originValue) {
        if (null == originValue || "".equals(originValue)) return originValue;
        return new BigDecimal(originValue).setScale(2, RoundingMode.HALF_UP).toString();
    }
    public static String set6Scale(String originValue) {
        if (null == originValue || "".equals(originValue)) return BigDecimal.ZERO.toPlainString();
        return new BigDecimal(originValue).setScale(6, RoundingMode.HALF_UP).toString();
    }

}
