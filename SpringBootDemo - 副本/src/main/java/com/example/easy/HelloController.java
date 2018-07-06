package com.example.easy;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * yutianran 2017/1/19 下午6:33
 */
@RestController
public class HelloController {

    @RequestMapping(value = "hello")
    public String say(){
        return "Hello Spring Boot!";
    }
}
