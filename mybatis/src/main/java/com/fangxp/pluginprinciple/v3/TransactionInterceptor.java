package com.fangxp.pluginprinciple.v3;

import com.fangxp.pluginprinciple.Invocation;

public class TransactionInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) {
        System.out.println("before execute transaction...");
        Object result = invocation.process();
        System.out.println("after execute transaction...");
        return result;
    }

    @Override
    public Object plugin(Object target) {
        return TargetProxy.wrap(target, this);
    }
}
