package com.bf.JVM.ref_transfer;

/**
 * @Author bofei
 * @Date 2019/4/2 11:46
 * @Description
 */
public class User {
    private Integer age;
    private String name;

    public User(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public static void changeUser(User user) {
        user = new User(100, "u");
//        user.setAge(100);
        System.out.println(user);
    }
    public static void main(String[] args) {
        User a = new User(18, "a");
//        a = new User(19, "b");
//        System.out.println(a);
        System.out.println(a + " xxx");// 等同于a.toStirng() + " xxx"

        changeUser(a);
        System.out.println(a);// 这里更说明了 Java 只有 值传递

    }
}
