package com.fangxp.plugin;

import mybatisimpl.plugin.BdInterceptor;
import mybatisimpl.plugin.BdPlugin;
import mybatisimpl.plugin.Invocation;

public class BdLogInterceptor implements BdInterceptor {

    @Override
    public Object intercept(Invocation invocation) {

        System.out.println("前置日志打印");
        Object result = invocation.process();
        System.out.println("后置日志");
        return result;
    }

    @Override
    public Object Plugin(Object target) {
        return BdPlugin.wrap(target, this);
    }

}
