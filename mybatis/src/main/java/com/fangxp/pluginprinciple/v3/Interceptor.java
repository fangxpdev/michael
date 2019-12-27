package com.fangxp.pluginprinciple.v3;

import com.fangxp.pluginprinciple.Invocation;

public interface Interceptor {

    /**
     * 拦截器方法
     * invocation对象可执行原对象方法
     *
     * @param invocation
     * @return
     */
    Object intercept(Invocation invocation);

    Object plugin(Object target);

}
