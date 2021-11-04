package com.mantou.compare;

import com.mantou.entity.Student;

import java.util.Comparator;
/**
 * @author mantou
 * @date 2021/11/4 14:56
 * @desc 外部比较器
 */
public class StudentCompare implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getName().compareTo(o2.getName()) == 0) {
            return o1.getAge() - o2.getAge() ;
        }
        return o1.getName().compareTo(o2.getName()) ;
    }
}