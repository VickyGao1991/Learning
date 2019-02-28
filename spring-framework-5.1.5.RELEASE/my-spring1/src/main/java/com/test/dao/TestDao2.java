package com.test.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope("prototype")
public class TestDao2 implements IMyDao{

	@Override
	public void query(){
		System.out.println("This is TestDao2...");
	}
}
