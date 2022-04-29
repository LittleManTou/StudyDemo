package com.mantou;

public class Singleton {
    public static void main(String[] args) {
        //饿汉式
        Person p1 = Person.getPerson();
        Person p2 = Person.getPerson();
        System.out.println(p1 == p2);
        //懒汉式
        PersonLazy p3 = PersonLazy.getPersonLazy();
        PersonLazy p4 = PersonLazy.getPersonLazy();
        System.out.println(p3 == p4);

    }
}
//饿汉式
class Person{
    private Person(){}
    private static final Person person = new Person();
    public static Person getPerson(){
        return person;
    }
}
//懒汉式
class PersonLazy{
    private PersonLazy(){}
    private volatile static PersonLazy personLazy = null;
    public synchronized static PersonLazy getPersonLazy(){
        if (personLazy == null) {
            personLazy = new PersonLazy();
        }else{
            System.out.println("该实例已经存在!");
        }
        return personLazy;
    }
}
