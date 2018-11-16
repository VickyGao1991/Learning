package com.test.client.main;

import com.test.client.generated.HelloWebService;
import com.test.client.generated.HelloWebServiceService;

public class Main {
    public static void main(String[] args) {
        HelloWebServiceService hw = new HelloWebServiceService();
        HelloWebService hws = hw.getHelloWebServicePort();
        String helloResponse = hws.hello("Vicky");// 如同调用本地service 方法一样调用 Webservice 发布的方法
        System.out.println(helloResponse);
        String byeResponse = hws.bye(); // 如同调用本地service 方法一样调用 Webservice 发布的方法
        System.out.println(byeResponse);
    }
}
