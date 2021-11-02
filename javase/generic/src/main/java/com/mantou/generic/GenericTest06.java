package com.mantou.generic;

import com.mantou.entity.Person;
import com.mantou.entity.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mantou
 * @date 2021/11/2 10:02
 * @desc 泛型受限
 */
public class GenericTest06 {
    public static void main(String[] args) {
        //list1 list2 list3 是并列关系
        List<Object> list1 = new ArrayList<>();
        List<Person> list2 = new ArrayList<>();
        List<Student> list3 = new ArrayList<>();
        //定义泛型上限
        List<? extends Person> list = null;
        //list = list1 ; 报错  大于上线Person
        list = list2 ;
        list = list3 ;
        //定义泛型下限
        List<? super Person> list4 =null;
        list4 = list1 ;
        list4 = list2 ;
        //list4 = list3 ;  报错   小于下限Person
    }
}
