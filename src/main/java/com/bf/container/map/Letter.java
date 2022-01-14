package com.bf.container.map;

public class Letter {
    private String name;
    private int count;

    public Letter(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Letter{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
