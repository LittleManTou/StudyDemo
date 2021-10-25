package com.mantou.controller;

import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restb")
public class RestB {
    @GetMapping("/hello")
    public String hello(String name) {

        return  " hello rest !" + name ;
    }

}
