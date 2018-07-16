package com.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/index")
    public String index(){
        System.out.println("This is a index request");
        return "hello";
    }
}
