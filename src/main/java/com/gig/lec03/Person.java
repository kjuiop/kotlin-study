package com.gig.lec03;

/**
 * @author : JAKE
 * @date : 2025/06/15
 */
public class Person {

    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return age;
    }
}
