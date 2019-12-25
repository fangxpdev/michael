package mybatisimpl.session;

import mybatisimpl.configuration.BdConfiguration;
import mybatisimpl.mapper.BdMapperProxy;

import java.lang.reflect.Proxy;

public class BdSqlSession {

    private BdConfiguration bdConfiguration;

    public BdSqlSession(BdConfiguration bdConfiguration) {
        this.bdConfiguration = bdConfiguration;
    }

    public <T> T getMapper(Class<T> clazz) {

        T mapper = (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new BdMapperProxy(bdConfiguration));

        return mapper;
    }


}
