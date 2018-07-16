package com.augu.manual.service;

import java.util.Map;

public interface IMyService {
    int insert(Map map);
    
    int delete(Map map);
 
    int update(Map map);
 
    int select(Map map);
}
