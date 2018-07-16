package com.augu.manual.service.impl;

import java.util.Map;

import com.augu.manual.annotation.Service;
import com.augu.manual.service.IMyService;

@Service("MyServiceImpl")
public class MyServiceImpl implements IMyService {

    @Override
    public int insert(Map map) {
        System.out.println("This is MyServiceImpl.insert()");
        return 9;
    }

    @Override
    public int delete(Map map) {
        System.out.println("This is MyServiceImpl.delete()");
        return 9;
    }

    @Override
    public int update(Map map) {
        System.out.println("This is MyServiceImpl.update()");
        return 9;
    }

    @Override
    public int select(Map map) {
        System.out.println("This is MyServiceImpl.select()");
        return 9;
    }

}
