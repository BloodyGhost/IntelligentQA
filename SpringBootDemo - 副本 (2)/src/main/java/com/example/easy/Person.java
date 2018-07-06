package com.example.easy;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * yutianran 2017/1/19 下午6:43
 */
public class Person {
    @JsonProperty("user_name")
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

}
