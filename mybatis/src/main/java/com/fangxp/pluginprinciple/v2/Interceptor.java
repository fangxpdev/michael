package com.fangxp.pluginprinciple.v2;

import com.fangxp.pluginprinciple.Invocation;

public interface Interceptor {

    Object intercept(Invocation invocation);

}
