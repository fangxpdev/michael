package mybatisimpl.session;

import mybatisimpl.configuration.BdConfiguration;
import mybatisimpl.excutor.BdExecutor;
import mybatisimpl.mapper.BdMapperData;
import mybatisimpl.mapper.BdMapperProxy;

import java.lang.reflect.Proxy;
import java.util.List;

public class BdSqlSession {

    private BdConfiguration bdConfiguration;

    private BdExecutor bdExecutor;

    public BdSqlSession(BdConfiguration bdConfiguration, BdExecutor bdExecutor) {
        this.bdConfiguration = bdConfiguration;
        this.bdExecutor = bdExecutor;
    }

    public <T> T getMapper(Class<T> clazz) {

        T mapper = (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new BdMapperProxy(bdConfiguration, this));

        return mapper;
    }


    public <E> E selectOne(BdMapperData bdMapperData, Object[] args) {

        List<E> result = bdExecutor.execute(bdMapperData, args);

        if (result != null && result.size() > 1) {
            throw new RuntimeException("too money result");
        } else if (result == null) {
            return null;
        }

        return result.get(0);
    }
}
