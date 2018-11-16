package com.test.services;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * 定义一个服务类
 * 除了静态方法，final方法和加@@WebMethod(exclude=true)的方法不能被发布，其余方法都会被发布
 * @WebService 用来发布一个服务类
 */
@WebService
public class HelloWebService {
    public String hello(String name) {
        return "Hello " + name + ", welcome to the world of web service !!!";
    }

    public String bye() {
        return "Bye Bye!";
    }

    /**
     * 这个方法是静态的，不会被发布
     * */
    public static String staticMethod() {
        return "This method cannot be published as it is static.";
    }

    /**
     * 这个方法是final的，不会被发布
     * */
    public final String finalMathod() {
        return "This method cannot be published as it is final.";
    }

    /**
     * 这个方法添加了@WebMethod，不会被发布
     * */
    @WebMethod(exclude=true)
    public final String excludeMathod() {
        return "This method cannot be published as it has @WebMethod.";
    }
}