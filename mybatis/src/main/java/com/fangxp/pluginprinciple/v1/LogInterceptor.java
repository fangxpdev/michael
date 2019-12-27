package com.fangxp.pluginprinciple.v1;

public class LogInterceptor implements Interceptor {

    @Override
    public void intercept() {
        System.out.println(" log。。。");
    }

}
