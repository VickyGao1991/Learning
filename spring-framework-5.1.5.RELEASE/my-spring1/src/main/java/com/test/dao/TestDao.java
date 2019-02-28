package com.test.dao;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Repository;
;import javax.annotation.PostConstruct;

@Repository
@Description("This is TestDao description!")
public class TestDao implements IMyDao, ApplicationContextAware {

	ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Override
	public void query(){
		System.out.println("TestDao: Hello Spring!");
		// 实现接口ApplicationContextAware 的setApplicationContext方法,可以解决原型bean 被注入单例bean 失效问题
		//System.out.println(applicationContext.getBean("testDao2").hashCode());
	}

}
