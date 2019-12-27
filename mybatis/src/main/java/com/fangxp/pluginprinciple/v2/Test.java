package com.fangxp.pluginprinciple.v2;


import com.fangxp.pluginprinciple.Target;
import com.fangxp.pluginprinciple.TargetImpl;

/**

 * 支持环绕代理
 *
 * 代理手动一层一层的包装 看着有点恶心 持续优化
 * @see v3
 */
public class Test {

    public static void main(String[] args) {

        Target target =new TargetImpl();

        LogInterceptor logInterceptor = new LogInterceptor();

        Target targetProxy = (Target) TargetProxy.wrap(target,logInterceptor);

        TransactionInterceptor transactionInterceptor = new TransactionInterceptor();

        Target targetProxy2 = (Target) TargetProxy.wrap(targetProxy,transactionInterceptor);

        targetProxy2.execute();

    }

}
