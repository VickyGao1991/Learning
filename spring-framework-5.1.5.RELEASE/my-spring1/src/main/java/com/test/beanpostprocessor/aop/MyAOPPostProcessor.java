package com.test.beanpostprocessor.aop;

import com.test.dao.IMyDao;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Proxy;

public class MyAOPPostProcessor implements BeanPostProcessor {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// 如果要去拿名字为"testDao" 的bean 则返回一个代理类
		if (beanName.equals("testDao")){
			bean = Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{IMyDao.class}, new MyInvocationHandler(bean));
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return null;
	}
}
