package com.augu.manual.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Controller 注解
 * @author yt00411
 * 
 * @Documented，@Target 和 @Retention 都是元注解----是注解的注解
 * @Documented 注明该注解会被包含在javadoc中
 * @Target 定义注解的作用目标，作用范围
 * @Retention 定义了注解的保留策略
 *     - source 注解仅存在不源码中，class字节码文件中不存在
 *     - class 默认的保留策略，注解在class字节码文件中存在，但在运行时无法获得
 *     - runtime 注解在class字节码文件中存在，并在运行时可以通过反射获得到
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Controller {

    String value() default "";
}
