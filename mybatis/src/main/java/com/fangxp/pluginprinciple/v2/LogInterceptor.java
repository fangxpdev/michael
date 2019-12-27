package com.fangxp.pluginprinciple.v2;

import com.fangxp.pluginprinciple.Invocation;

public class LogInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) {
        System.out.println("before execute log...");
        Object result = invocation.process();
        System.out.println("after execute log...");
        return result;
    }


}
