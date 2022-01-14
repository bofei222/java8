package com.bf.java8;

import org.apache.commons.text.*;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: bofei
 * @date: 2019-11-22 19:43
 **/
public class Placeholder {
    /**
     * 替换
     * @param source 源内容
     * @param parameter 占位符参数
     * 转义符默认为'$'。如果这个字符放在一个变量引用之前，这个引用将被忽略，不会被替换 如$${a}将直接输出${a}
     * @return
     */
    public static String replace(String source,Map<String, String> parameter){
        StrSubstitutor strSubstitutor = new StrSubstitutor(parameter,"${", "}");
        strSubstitutor.setEnableSubstitutionInVariables(true);
        return strSubstitutor.replace(source);
    }

    /**
     * 测试
     */
    public static void test(){
        //替换字符串中的占位符
        Map<String, String> params = new HashMap<>();
        params.put("h", "3");
        params.put("j", "2");
        params.put("k", "3");



        Map<String, F<C>> params2 = new HashMap<>();
        params2.put("h", C::getH);

        C c = new C();

        int h = params2.get("h").apply(c);

//        Method method;method.invoke();
        System.out.println(h);


        String replace = replace("(${h}-${j})*${k}", params); // (${h}-${j})*${k}  --> (3-2)*3
        System.out.println(replace);
    }

    public static void main(String[] args) {
        test();

    }
}