package com.mantou.entity;

public class Person implements Comparable<Person>{
    private String name ;
    private Integer age ;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
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
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    //内部比较器
    @Override
    public int compareTo(Person o) {
        if(this.name.compareTo(o.getName()) == 0) {
            return this.age - o.getAge() ;
        }
        return this.name.compareTo(o.getName());
    }
}
