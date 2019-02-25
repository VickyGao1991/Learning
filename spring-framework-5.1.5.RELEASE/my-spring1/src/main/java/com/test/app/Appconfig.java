package com.test.app;

import com.test.annotation.EnableMyTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.test")
@EnableMyTest
public class Appconfig {
}
