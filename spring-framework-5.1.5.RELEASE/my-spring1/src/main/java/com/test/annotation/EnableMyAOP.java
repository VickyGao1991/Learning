package com.test.annotation;


import com.test.beanpostprocessor.aop.MyAOPPostProcessor;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(MyAOPPostProcessor.class)
public @interface EnableMyAOP {
}
