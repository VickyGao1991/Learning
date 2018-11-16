package com.test.publisher;

import javax.xml.ws.Endpoint;

import com.test.services.HelloWebService;

/**
 * 该类用来发布 WebService
 */
public class Publisher {
    // 分配给一个WebService即将要发布的地址
    private static final String HELLO_WEB_SERVICE_ADDRESS = "http://localhost:8080/helloWebService";

    public static void main(String[] args) {
        // 通过Endpoint端点服务发布WebService， 参数1：本地的服务地址，参数2： 提供服务的类
        Endpoint.publish(HELLO_WEB_SERVICE_ADDRESS, new HelloWebService());
        System.out.println("wsdl的地址：" + HELLO_WEB_SERVICE_ADDRESS + "?WSDL");
    }
}
