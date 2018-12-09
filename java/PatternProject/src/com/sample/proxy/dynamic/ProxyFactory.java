package com.sample.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        Object instance = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new InvocationHandler() {

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 执行目标方法前,做点啥?
                        System.out.println(method.getName());
                        System.out.println(method.getParameterCount());
                        System.out.println(String.valueOf(args));
                        Object excuteResult = method.invoke(target, args);
                        // 执行目标方法后,做点啥?
                        return excuteResult;
                    }
                });
        return instance;
    }
}
