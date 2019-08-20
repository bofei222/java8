package com.bf;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.CaseFormat;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.util.Set;

/**
 * @description: 下划线转驼峰
 * @author: bofei
 * @date: 2019-08-13 18:48
 **/
public class GuavaTester {

    private String userName;
    private String userAge;
    String aa;

    public String getAa() {
        return aa;
    }

    public void setAa(String aa) {
        this.aa = aa;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    @Override
    public String toString() {
        return "GuavaTester{" +
                "userName='" + userName + '\'' +
                ", userAge='" + userAge + '\'' +
                ", aa='" + aa + '\'' +
                '}';
    }

    public <T> T underline2Camel(JSONObject jo, Class<T> c) {
        Set<String> keys = jo.keySet();
        JSONObject jo2 = new JSONObject();
        for (String key : keys) {
            String newKey = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, key);
            jo2.put(newKey, jo.getString(key));
        }
        T t = JSON.toJavaObject(jo2, c);
        return t;
    }

    @Test
    public void test3() {
        JSONObject jo = new JSONObject();
        jo.put("user_name", "xx");
        jo.put("user_age", "yy");
        jo.put("user_age2", "yy");
        GuavaTester guavaTester = underline2Camel(jo, GuavaTester.class);
        System.out.println(guavaTester);
    }

    @Test
    public void test() {

        JSONObject jo = new JSONObject();
        jo.put("user_name", "xx");
        jo.put("user_age", "yy");

        Set<String> keys = jo.keySet();
        JSONObject jo2 = new JSONObject();
        for (String key : keys) {
            String newKey = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, key);
//            System.out.println(newKey);
            jo2.put(newKey, jo.getString(key));

        }
        System.out.println(jo2);

        GuavaTester g = new GuavaTester();
//        GuavaTester g2 = new GuavaTester();
//        g2.setUserName("xx");

//        BeanUtils.copyProperties(jo2, g);
//        System.out.println(g);

        GuavaTester g3 = JSON.toJavaObject(jo2, GuavaTester.class);
        System.out.println(g3);
        BeanUtils.copyProperties(g3, g);
        System.out.println(g);

//        BeanUtils.copyProperties(g2, g);
//        System.out.println(g);

//        System.out.println(CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL, "test-data"));//testData
//        System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "test_data"));//testData
//        System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, "test_data"));//TestData

//        System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, "testdata"));//testdata
//        System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, "TestData"));//test_data
//        System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_HYPHEN, "testData"));//test-data

    }

}
