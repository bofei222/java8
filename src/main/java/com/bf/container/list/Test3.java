package com.bf.container.list;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @description:
 * @author: bofei
 * @date: 2019-09-19 09:56
 **/
public class Test3 {

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        User u1 = new User(1, "a");
        User u2 = new User(2, "a");
        User u3 = new User(3, "a");
        list.add(u1);
        list.add(u2);
        list.add(u3);

        for (User u : list) {
            u.setFlag("1");
            for (User uu : list) {
                if ((u != uu) && u.equals(uu)) {
                    System.out.println("进入 " + u);
                }
            }
        }
    }
}
@Data
class User {
    private Integer id;
    private String name;
    private String Flag;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}