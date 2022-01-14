package com.bf.classs.sub;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 判断 是否是List类型
 * @author: bofei
 * @date: 2019-12-03 18:00
 **/
public class Test02 {
    public static String getStringAbel(List<?> o, Class<?> c, String field) {
        StringBuffer result = new StringBuffer();
        if (StringUtils.isNoneBlank(field)) {
            Field[] fields = c.getDeclaredFields();
            int pos;
            for (pos = 0; pos < fields.length; pos++) {
                if (field.equals(fields[pos].getName())) {
                    break;
                }
            }
            for (Object o1 : o) {
                try {
                    fields[pos].setAccessible(true);
                    result.append(fields[pos].get(o1) + ",");
                } catch (Exception e) {
                    System.out.println("error--------" + "Reason is:" + e.getMessage());
                }
            }
        }
        return result.deleteCharAt(result.length() - 1).toString();
    }

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        Person person = new Person();
        person.setName("abel");
        person.setAge(16);

        Person person2 = new Person();
        person2.setName("abel2");
        person2.setAge(17);

        Person person3 = new Person();
        person3.setName("abel2");
        person3.setAge(17);

        personList.add(person);
        personList.add(person2);
        personList.add(person3);

        System.out.println(getStringAbel(personList, Person.class, "name"));

    }
}

@Data
class Person {
    private String name;
    private Integer age;
}