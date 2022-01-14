package com.bf;

import java.math.BigDecimal;

import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * @description:
 * @author: bofei
 * @date: 2019-12-04 14:08
 **/
public class MathUtils {
    public static void main(String[] args) {
        String s = MathUtils.elegantMultiply("800.0100", "1");
        System.out.println(s);

        BigDecimal b = new BigDecimal("0.00");
        if (b.compareTo(BigDecimal.ZERO) == 0.0000) {
            System.out.println(0);
        }
    }
    public static String elegantMultiply(String v1, String v2) {
        if (isBlank(v1)) {
            return "";
        }
        if (isBlank(v2)) {
            return "";
        }
        BigDecimal b1 = new BigDecimal(v1.trim());
        BigDecimal b2 = new BigDecimal(v2.trim());
        return String.valueOf(multiply(b1, b2).stripTrailingZeros().toPlainString());
    }

    public static BigDecimal multiply(BigDecimal v1, BigDecimal v2) {
        if (null == v1) {
            v1 = BigDecimal.ONE;
        }
        if (null == v2) {
            v2 = BigDecimal.ONE;
        }
        return v1.multiply(v2);
    }

    public static BigDecimal add(BigDecimal v1, BigDecimal v2) {
        if (null == v1) {
            v1 = BigDecimal.ZERO;
        }
        if (null == v2) {
            v2 = BigDecimal.ZERO;
        }
        return v1.add(v2);
    }

    public static String add(String v1, String v2) {
        if (isBlank(v1)) {
            v1 = "0";
        }
        if (isBlank(v2)) {
            v2 = "0";
        }
        BigDecimal b1 = new BigDecimal(v1.trim());
        BigDecimal b2 = new BigDecimal(v2.trim());
        return String.valueOf(add(b1, b2));
    }

    public static String sum(String v1, String... valList) {
        if (isBlank(v1)) {
            v1 = "0";
        }
        if (null == valList || valList.length == 0) {
            return v1;
        }
        BigDecimal b1 = new BigDecimal(v1.trim());
        for (String val : valList) {
            if (!isBlank(val)) {
                b1 = add(b1, new BigDecimal(val.trim()));
            }
        }
        return String.valueOf(b1);
    }

    public static BigDecimal sum(BigDecimal v1, BigDecimal... valList) {
        if (null == v1) {
            v1 = BigDecimal.ZERO;
        }
        if (null == valList || valList.length == 0) {
            return v1;
        }
        for (BigDecimal val : valList) {
            if (null != val) {
                v1 = v1.add(val);
            }
        }
        return v1;
    }
}
