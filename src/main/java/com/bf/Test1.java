package com.bf;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description: 处理List<Map>数据
 * @author: bofei
 * @date: 2019-12-03 14:12
 **/
public class Test1 {
    public static void main(String[] args) {
        JSONObject jsonObject = JSONObject.parseObject("{\n" +
                "\t\"monthlyPlan\": [{\n" +
                "\t\t\"month\": \"2019年12月\",\n" +
                "\t\t\"year_decompose_electricity\": \"1\",\n" +
                "\t\t\"contract_id\": \"115e3b88a10848b18de07b4a5eec4af1\",\n" +
                "\t\t\"month_bidding_electricity\": \"\",\n" +
                "\t\t\"month_bidding_price\": \"\",\n" +
                "\t\t\"year_decompose_price\": \"\"\n" +
                "\t}, {\n" +
                "\t\t\"month\": \"2020年1月\",\n" +
                "\t\t\"year_decompose_electricity\": \"1\",\n" +
                "\t\t\"contract_id\": \"115e3b88a10848b18de07b4a5eec4af1\",\n" +
                "\t\t\"month_bidding_electricity\": \"\",\n" +
                "\t\t\"month_bidding_price\": \"\",\n" +
                "\t\t\"year_decompose_price\": \"\"\n" +
                "\t}, {\n" +
                "\t\t\"month\": \"2020年2月\",\n" +
                "\t\t\"year_decompose_electricity\": \"1\",\n" +
                "\t\t\"contract_id\": \"115e3b88a10848b18de07b4a5eec4af1\",\n" +
                "\t\t\"month_bidding_electricity\": \"\",\n" +
                "\t\t\"month_bidding_price\": \"\",\n" +
                "\t\t\"year_decompose_price\": \"\"\n" +
                "\t}, {\n" +
                "\t\t\"month\": \"2020年3月\",\n" +
                "\t\t\"year_decompose_electricity\": \"9\",\n" +
                "\t\t\"contract_id\": \"115e3b88a10848b18de07b4a5eec4af1\",\n" +
                "\t\t\"month_bidding_electricity\": \"\",\n" +
                "\t\t\"month_bidding_price\": \"\",\n" +
                "\t\t\"year_decompose_price\": \"\"\n" +
                "\t}, {\n" +
                "\t\t\"year_decompose_electricity\": \"年度双边分解电量\",\n" +
                "\t\t\"month\": \"月份\",\n" +
                "\t\t\"month_bidding_electricity\": \"月度竞价分解电量\",\n" +
                "\t\t\"month_bidding_price\": \"月度竞价分解电价\",\n" +
                "\t\t\"year_decompose_price\": \"年度双边分解电价\"\n" +
                "\t}]\n" +
                "}");
        System.out.println(jsonObject);

        String monthlyPlan = jsonObject.getString("monthlyPlan");
        JSONArray jarr = JSONObject.parseArray(monthlyPlan);


        List<Map> list = JSONObject.parseArray(monthlyPlan, Map.class);
        List<TreeMap> treeMapList = new ArrayList<>();
        for (Map map : list) {
            TreeMap treeMap = new TreeMap<>(map);
            treeMapList.add(treeMap);
        }

        List<LinkedHashMap> linkedHashMapList = new ArrayList<>();

        for (TreeMap treeMap : treeMapList) {
            Set<String> set = treeMap.keySet(); // 获取所有key
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("month", treeMap.get("month")); // 先 month 排在第一位
            for (String key : set) {
                if ("month".equals(key)) continue;
                linkedHashMap.put(key, treeMap.get(key));
                // 其他的顺序不变
            }
            linkedHashMapList.add(linkedHashMap);

        }


        StringBuffer sb = new StringBuffer();
        sb.append("<table>\n");
        Map tHeader = linkedHashMapList.get(linkedHashMapList.size() - 1);
//        tHeader.
        List<String> tHeaderList = new ArrayList(tHeader.values());
        System.out.println(tHeaderList);
        sb.append("<tr>\n");
        //
        for (String s : tHeaderList) {
            sb.append("<td>");
            sb.append(s);
            sb.append("</td>");
        }
        sb.append("\n</tr>\n");

        // 表内容
        for (int i = 0; i < linkedHashMapList.size() - 1; i++) { // -1 是表头
            Map map = linkedHashMapList.get(i);
            map.remove("contract_id");
            sb.append("<tr>\n");
            List<String> tbodyList = new ArrayList(map.values());
            for (String s : tbodyList) {
                sb.append("<td>");
                sb.append(s);
                sb.append("</td>");
            }
            sb.append("\n</tr>\n");
            System.out.println(tbodyList);
        }
        sb.append("</table>");
        System.out.println(sb);
        System.out.println(jarr);
        LinkedHashMap amountMap = new LinkedHashMap();
        amountMap.put("month", "合计");
        for (int i = 0; i < linkedHashMapList.size() - 1; i++) {
            LinkedHashMap linkedHashMap = linkedHashMapList.get(i);
            Set<String> set = linkedHashMap.keySet();
            for (String key : set) {
                if ("month" != key) {
                    amountMap.put(key, MathUtils.add(
                            String.valueOf(amountMap.get(key) != null ? amountMap.get(key) : "0"),
                            String.valueOf(linkedHashMap.get(key) != null ? linkedHashMap.get(key) : "0")));
                }
            }
        }
        System.out.println(amountMap);
        List<String> list2 = new ArrayList<>(amountMap.values());
        StringBuffer sb2 = new StringBuffer();
        sb2.append("<table><tr>");

        for (String s : list2) {
            sb2.append("<td>");
            sb2.append(s);
            sb2.append("</td>");
        }
        sb2.append("</tr></table>");
        System.out.println(sb2);
    }
}
