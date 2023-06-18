package com.test;


import java.io.Serializable;

public class MyUser implements Serializable,Comparable<MyUser> {

    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "MyUser{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyUser myUser = (MyUser) o;

        if (name != null ? !name.equals(myUser.name) : myUser.name != null) return false;
        return age != null ? age.equals(myUser.age) : myUser.age == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }

    public MyUser() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int compareTo(MyUser o) {
        return this.getAge().compareTo(o.getAge());
    }


}
