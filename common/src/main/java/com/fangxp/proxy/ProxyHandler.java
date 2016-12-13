package com.fangxp.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/12/6.
 */
public class ProxyHandler implements InvocationHandler {

    People people = null;

    public ProxyHandler(People people) {
        this.people = people;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        method.invoke(people, null);
        after();
        return null;
    }

    private void before() {
        System.out.println("吃饭之前先洗手!!");
    }

    private void after() {
        System.out.println("吃饭之后要洗碗!!!");
    }

}
