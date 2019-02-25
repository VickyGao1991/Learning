package com.test.annotation;

import com.test.selector.MySelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(MySelector.class)
public @interface EnableMyTest {
}
