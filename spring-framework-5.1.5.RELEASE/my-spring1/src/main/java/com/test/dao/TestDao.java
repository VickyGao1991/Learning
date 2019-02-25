package com.test.dao;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Repository;
;

@Repository
@Description("This is TestDao description!")
public class TestDao implements ApplicationContextAware {

	ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public void query(){
		System.out.println("TestDao: Hello Spring!");
		//System.out.println(applicationContext.getBean("testDao2").hashCode());
	}

}
