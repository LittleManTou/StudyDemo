package com.mantou.set;

import com.mantou.entity.Person;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author mantou
 * @date 2021/11/4 15:52
 * @desc TreeSet特点
 *
 */
public class TreeSetTest {
    public static void main(String[] args) {
        //使用内部比较器
        TreeSet<Person> treeSet = new TreeSet<>();
        treeSet.add(new Person("mantou",23));
        treeSet.add(new Person("lisi",24));
        treeSet.add(new Person("mantou",25));
        treeSet.add(new Person("zhangsan",26));
        treeSet.add(new Person("wangwu",23));
        for (Person person : treeSet) {
            System.out.println(person);
        }
        System.out.println("------------------------------------------");
        //使用外部比较器，写法为直接传入匿名内部类
        TreeSet<Person> treeSet2 = new TreeSet<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.getName().compareTo(o2.getName()) == 0) {
                    return o1.getAge() - o2.getAge() ;
                }
                return o1.getName().compareTo(o2.getName());
            }
        });
        treeSet2.add(new Person("mantou2",23));
        treeSet2.add(new Person("lisi2",24));
        treeSet2.add(new Person("mantou2",25));
        treeSet2.add(new Person("zhangsan2",26));
        treeSet2.add(new Person("wangwu2",23));
        for (Person person : treeSet2) {
            System.out.println(person);
        }
    }
}
