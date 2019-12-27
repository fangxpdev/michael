package mybatisimpl.plugin;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BdPlugin implements InvocationHandler {

    private Object target;

    private BdInterceptor bdInterceptor;

    public BdPlugin(Object target, BdInterceptor bdInterceptor) {
        this.target = target;
        this.bdInterceptor = bdInterceptor;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Invocation invocation = new Invocation(target, method, args);

        return bdInterceptor.intercept(invocation);

    }

    public static Object wrap(Object target, BdInterceptor bdInterceptor) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new BdPlugin(target, bdInterceptor));
    }

}
