package com.mantou.main;

import com.mantou.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring01Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/mantou/Spring01.xml");
        User user = context.getBean("user",User.class);
        user.print();
    }
}
