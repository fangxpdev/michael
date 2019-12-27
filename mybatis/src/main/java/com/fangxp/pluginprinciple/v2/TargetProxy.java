package com.fangxp.pluginprinciple.v2;

import com.fangxp.pluginprinciple.Invocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TargetProxy implements InvocationHandler {

    private Object target;

    private Interceptor interceptor;

    public TargetProxy(Object target, Interceptor interceptor) {
        this.target = target;
        this.interceptor = interceptor;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Invocation invocation = new Invocation(target, method, args);

        return interceptor.intercept(invocation);
    }

    public static Object wrap(Object target, Interceptor interceptor) {

        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new TargetProxy(target, interceptor));

    }


}
