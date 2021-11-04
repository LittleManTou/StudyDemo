package com.mantou.compare;

import com.mantou.entity.Student;

import java.util.Arrays;
import java.util.Comparator;


/**
 * @author mantou
 * @date 2021/11/4 14:41
 * @desc 比较器的使用
 * 外部比较器可以使用多态，所以扩展性更好
 */
public class CompareTest {
    public static void main(String[] args) {
        //使用内部比较器比较自定义对象
        Student stu1 = new Student("wangwu",23);
        Student stu2 = new Student("mantou",24);
        Student stu3 = new Student("mantou",25);
        Student stu4 = new Student("mantou", 23);
        Student[] students = new Student[] {stu1,stu2,stu3,stu4} ;
        Arrays.sort(students);
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("-------------------------------------------");
        //使用外部比较器比较自定义对象
        Comparator<Student> comparator = new StudentCompare();
        Student[] students2 = new Student[] {stu1,stu2,stu3,stu4} ;
        Arrays.sort(students2 , new StudentCompare());
        for (Student student : students2) {
            System.out.println(student);
        }

    }
}
