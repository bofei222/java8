package com.bf.jichu;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * @description:
 * @author: bofei
 * @date: 2020-07-02 19:26
 **/
public class StringDealUtils {
    /**
     * 处理特殊字符问题
     *
     * @param phone
     * @return
     */
    public static String dealBlankString(String phone) {
        if (StringUtils.isNotBlank(phone)) {
            phone = removeNonAscii(phone);
            phone = removeSomeControlChar(phone);
            phone = removeFullControlChar(phone).trim();
            return phone;
        }
        return null;
    }
    /**
     * 去除非ascii码字符
     *
     * @param str
     * @return
     */
    public static String removeNonAscii(String str) {
        return str.replaceAll("[^\\x00-\\x7F]", "");
    }
    /**
     * 去除不可打印字符
     *
     * @param str
     * @return
     */
    public static String removeNonPrintable(String str) {
        return str.replaceAll("[\\p{C}]", "");
    }

    /**
     * 去除一些控制字符 Control Char
     *
     * @param str
     * @return
     */
    public static String removeSomeControlChar(String str) {
        return str.replaceAll("[\\p{Cntrl}\\p{Cc}\\p{Cf}\\p{Co}\\p{Cn}]", ""); // Some Control Char
    }

    /**
     * 去除一些换行制表符
     *
     * @param str
     * @return
     */
    public static String removeFullControlChar(String str) {
        return removeNonPrintable(str).replaceAll("[\\r\\n\\t]", "");
    }




    public static void main(String[] args) {
        String password1 ="16473328838\u202C";
        String password2 ="16473328838";
        System.out.println("password1:"+password1.length());
        System.out.println("password2:"+password2.length());
        System.out.println("password1:"+ StringDealUtils.dealBlankString(password1).length());
        System.out.println("password2:"+StringDealUtils.dealBlankString(password2).length());
    }
}