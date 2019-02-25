package com.test.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class TestBeanPostProcessor implements BeanPostProcessor {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if ("testDao".equals(beanName)){
			System.out.println("TestBeanPostProcessor: before TestDao...");
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if ("testDao".equals(beanName)){
			System.out.println("TestBeanPostProcessor: after TestDao...");
		}
		return bean;
	}
}
