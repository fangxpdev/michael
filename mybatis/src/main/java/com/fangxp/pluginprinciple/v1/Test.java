package com.fangxp.pluginprinciple.v1;

import com.fangxp.pluginprinciple.Target;
import com.fangxp.pluginprinciple.TargetImpl;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;

/**
 * 动态代理
 *
 * 只能支持前置代理
 */
public class Test {

    public static void main(String[] args) {

//        saveProxyClassFile();

        Target target = new TargetImpl();

        LogInterceptor interceptor = new LogInterceptor();

        Target proxyTarget = (Target) TargetProxy.wrap(target, interceptor);

        proxyTarget.execute();


    }

    /**
     * 文件位置 在classes目录下
     * <p>
     * 保存动态代理生成的class文件
     * 代理类执行execute方式时 实际执行的是实现InvocationHandler的子类实现的invoke方法
     *
     *  public final void execute() throws  {
     *         try {
     *             super.h.invoke(this, m3, (Object[])null);
     *         } catch (RuntimeException | Error var2) {
     *             throw var2;
     *         } catch (Throwable var3) {
     *             throw new UndeclaredThrowableException(var3);
     *         }
     *     }
     */
    public static void saveProxyClassFile() {
        try {
            byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy", new Class[]{Target.class});

            String classpath = Test.class.getResource(".").getPath();
            FileOutputStream fos = new FileOutputStream(new File(classpath + "$Proxy.class"));

            fos.write(bytes);
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
