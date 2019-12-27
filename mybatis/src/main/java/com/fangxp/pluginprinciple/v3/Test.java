package com.fangxp.pluginprinciple.v3;


import com.fangxp.pluginprinciple.Target;
import com.fangxp.pluginprinciple.TargetImpl;

/**
 * 支持环绕代理
 * 优化：
 * 1.优化拦截器插件注入方式
 */
public class Test {

    public static void main(String[] args) {

        /**
         * 第一种拦截器注入方式
         */

//        Target target = new TargetImpl();
//
//        LogInterceptor logInterceptor = new LogInterceptor();
//
//        target = (Target) logInterceptor.plugin(target);
//
//        TransactionInterceptor transactionInterceptor = new TransactionInterceptor();
//        target = (Target) transactionInterceptor.plugin(target);
//
//        target.execute();

        /**
         * 第二种：拦截器链
         */
        Target target = new TargetImpl();

        LogInterceptor logInterceptor = new LogInterceptor();
        TransactionInterceptor transactionInterceptor = new TransactionInterceptor();
        InterceptorChain chain = new InterceptorChain();
        chain.addInterceptor(logInterceptor);
        chain.addInterceptor(transactionInterceptor);

        target = (Target) chain.pluginAll(target);

        target.execute();

    }

}
