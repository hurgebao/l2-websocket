package com.sinoteif.l2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin on 2019/9/4.
 */
@RestController
public class HelloController {
    @RequestMapping("hello")
    public String    hello(){
        return "hello world!";
    }
}
