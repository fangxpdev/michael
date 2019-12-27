package com.fangxp.pluginprinciple.v2;

import com.fangxp.pluginprinciple.Invocation;

public class TransactionInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) {
        System.out.println("before execute transaction...");
        Object result = invocation.process();
        System.out.println("after execute transaction...");
        return result;
    }
}
