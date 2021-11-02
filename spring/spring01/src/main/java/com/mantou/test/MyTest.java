package com.mantou.test;

import com.mantou.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class MyTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
        Person person = applicationContext.getBean("person", Person.class);
        System.out.println(person);
        log.info("person:{}",person);

    }
}
