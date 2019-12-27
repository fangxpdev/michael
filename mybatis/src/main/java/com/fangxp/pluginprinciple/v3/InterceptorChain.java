package com.fangxp.pluginprinciple.v3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 拦截器链
 */
public class InterceptorChain {

    List<Interceptor> interceptorList = new ArrayList<>();


    /**
     * 导入所有拦截器
     * 每个拦截器位于一层代理
     *
     * @param target
     * @return
     */
    public Object pluginAll(Object target) {

        for (Interceptor interceptor : interceptorList) {
            target = interceptor.plugin(target);
        }
        return target;
    }


    /**
     * 添加拦截器
     *
     * @param interceptor
     */
    public void addInterceptor(Interceptor interceptor) {
        interceptorList.add(interceptor);
    }


    /**
     * 获取所有拦截器
     *
     * @return
     */
    public List<Interceptor> getInterceptorList() {
        return Collections.unmodifiableList(interceptorList);
    }
}
