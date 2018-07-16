package com.augu.manual.service.impl;

import java.util.Map;

import com.augu.manual.annotation.Service;
import com.augu.manual.service.ISpringService;

@Service("SpringServiceImpl")
public class SpringServiceImpl implements ISpringService {

    @Override
    public int insert(Map map) {
        System.out.println("This is SpringServiceImpl.insert()");
        return 6;
    }

    @Override
    public int delete(Map map) {
        System.out.println("This is SpringServiceImpl.delete()");
        return 6;
    }

    @Override
    public int update(Map map) {
        System.out.println("This is SpringServiceImpl.update()");
        return 6;
    }

    @Override
    public int select(Map map) {
        System.out.println("This is SpringServiceImpl.select()");
        return 6;
    }

}
