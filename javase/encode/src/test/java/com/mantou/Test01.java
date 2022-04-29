package com.mantou;

import org.junit.Test;

public class Test01 {
    @Test
    public  void method1() {
//        String x = "abc" ;
//       // method2(x);
//        getString(x);
//        System.out.println(x);
        Student student = new Student("mantou",24);
        updateStudent(student);
        System.out.println(student);

    }
    private void updateStudent(Student student) {
        student.setStuName("zhangsan");
        student.setStuAge(23);
    }

//    private String getString(String x) {
//        x = x + "d";
//        return x;
//    }
//
//    public  void method2(String x){
//        x += "d";
//    }


}
