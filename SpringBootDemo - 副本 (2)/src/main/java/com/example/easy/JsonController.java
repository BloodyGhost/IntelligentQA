package com.example.easy;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * yutianran 2017/1/19 下午6:35
 */
@RestController
public class JsonController {

    @RequestMapping("json")
    public Person resp(){
        Person xiaoming = new Person("xiaoming", 23);
        return xiaoming;
    }
}

