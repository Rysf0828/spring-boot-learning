package com.cnhachiman.web.domain;

public class Student {
    private String name;
    private int age;
    private int sex;
    private String address;

    public Student(String name, int age, int sex, String address) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
    }

    public Student() {
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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", address='" + address + '\'' +
                '}';
    }
}
