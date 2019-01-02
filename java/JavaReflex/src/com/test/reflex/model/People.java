package com.test.reflex.model;

public class People {
    private String name;
    private int age;

    public People() {
        System.out.println("this is people's construction method");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    static {
        System.out.println("this is people's static block");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{").append("\"name:\"").append(name).append(", \"age:\"").append(age).append("}");
        System.out.println("this is people's toString method");
        return sb.toString();
    }
}
