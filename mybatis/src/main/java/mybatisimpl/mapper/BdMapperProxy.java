package mybatisimpl.mapper;

import mybatisimpl.configuration.BdConfiguration;
import mybatisimpl.excutor.BdExecutor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class BdMapperProxy implements InvocationHandler {

    private BdConfiguration bdConfiguration;

    public BdMapperProxy(BdConfiguration bdConfiguration) {
        this.bdConfiguration = bdConfiguration;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        BdExecutor bdExecutor = bdConfiguration.getBdExecutor();


        bdExecutor.execute();


        return null;
    }

}
