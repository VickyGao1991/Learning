package com.sample.proxy.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * Cglib子类代理工厂. 在内存中动态构建一个子类对象
 */
public class ProxyFactory implements MethodInterceptor{
    private Object target;
    
    public ProxyFactory(Object target) {
        this.target = target;
    }
    
    // 给目标对象创建一个代理对象
    public Object getProxyInstance() {
        // 1.工具类
        Enhancer en = new Enhancer();
        // 2.设置父类
        en.setSuperclass(target.getClass());
        // 3.设置回调函数
        en.setCallback(this);
        // 4.创建子类(代理对象)
        return en.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        // 执行目标对象的方法
        Object returnValue = method.invoke(target, args);
        // OR 
        // Object returnValue = proxy.invokeSuper(obj, args);
        return returnValue;
    }
}
