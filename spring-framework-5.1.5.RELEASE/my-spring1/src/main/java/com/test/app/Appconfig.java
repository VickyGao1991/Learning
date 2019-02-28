package com.test.app;

import com.test.annotation.EnableMyAOP;
import com.test.annotation.EnableMyTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@ComponentScan("com.test")
@EnableMyTest
@EnableMyAOP
@Configuration // 加了这个注解就是full (全注册), 否则就是lite(部分注册)
public class Appconfig {
}
