package com.augu.manual.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.augu.manual.annotation.Controller;
import com.augu.manual.annotation.Quatifier;
import com.augu.manual.annotation.RequestMapping;
import com.augu.manual.service.IMyService;
import com.augu.manual.service.impl.SpringServiceImpl;

@Controller("test")
public class SpringmvcController {

    @Quatifier("MyServiceImpl")
    IMyService myService;

    @Quatifier("SpringServiceImpl")
    SpringServiceImpl springService;

    @RequestMapping("insert")
    public String insert(HttpServletRequest request, HttpServletResponse response, String param) {
        myService.insert(null);
        springService.insert(null);
        return null;
    }

    @RequestMapping("delete")
    public String delete(HttpServletRequest request, HttpServletResponse response, String param) {
        myService.delete(null);
        springService.delete(null);
        return null;
    }

    @RequestMapping("update")
    public String update(HttpServletRequest request, HttpServletResponse response, String param) {
        myService.update(null);
        springService.update(null);
        return null;
    }

    @RequestMapping("select")
    public String select(HttpServletRequest request, HttpServletResponse response, String param) {
        myService.select(null);
        springService.select(null);
        return null;
    }

}
