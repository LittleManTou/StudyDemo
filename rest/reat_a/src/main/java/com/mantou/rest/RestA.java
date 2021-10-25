package com.mantou.rest;

import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/resta")
public class RestA {
    @Autowired
    RestTemplate restTemplate;
    @Value("${rest.b.host}")
    private String host;
    @Value("${rest.b.port}")
    private String port;

    @RequestMapping("/toRest")
    @ResponseBody
    public String toRest(String name){
        String uri = host + ":9091"   + "/restb/hello?name=" + name;
        log.info( "uri : {}" , uri);
        log.info("name : {}" , name);
        RequestEntity<String> body1 = RequestEntity.post(uri).header(HttpHeaders.COOKIE, "key1=value1").body(name);
        ResponseEntity<JSONPObject> exchange = restTemplate.exchange(body1, JSONPObject.class);
        JSONPObject body = exchange.getBody();
        HttpHeaders headers = exchange.getHeaders();
        List<String> s = headers.get("s");
        log.info("Body : {}",body);
        return body.toString();
    }
}
