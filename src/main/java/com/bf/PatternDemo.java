package com.bf;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:
 * @author: bofei
 * @date: 2020-09-09 17:20
 **/
public class PatternDemo {
    public static void main(String[] args) {
        String completeFilePathName = "";
        Pattern p = Pattern.compile("\\d{4}_\\d{2}_\\d{2}[ _]\\d{2}.\\d{2}.\\d{2}");
        Matcher m = p.matcher(completeFilePathName);
        if (m.find()) {
            String group = m.group();
            String s = group.replaceAll("([ .])", "_");
            completeFilePathName = completeFilePathName.replaceAll(group, s);
        }

        // 解决这种 019_2020_07_20 00.36.56.zip
        Pattern p2 = Pattern.compile("\\d{3}(_\\d{3})_\\d{4}_\\d{2}_\\d{2}_\\d{2}_\\d{2}_(\\d{2})");
        Matcher m2 = p2.matcher(completeFilePathName);
        if (m2.find()) {
            String group1 = m2.group(1);
            String s = group1.replaceAll("_", ".");
            completeFilePathName = completeFilePathName.replaceAll(s, "");
            StringBuilder sb = new StringBuilder(completeFilePathName);
            sb.insert(m2.end(0) - 4, s);
            completeFilePathName = sb.toString();
        }
    }
}
