package mybatisimpl.mapper;

import mybatisimpl.configuration.BdConfiguration;
import mybatisimpl.session.BdSqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

public class BdMapperProxy implements InvocationHandler {

    private BdConfiguration bdConfiguration;

    private BdSqlSession bdSqlSession;

    public BdMapperProxy(BdConfiguration bdConfiguration, BdSqlSession bdSqlSession) {
        this.bdConfiguration = bdConfiguration;
        this.bdSqlSession = bdSqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        String sqlKey = method.getDeclaringClass().getName() + "." + method.getName();

        Map<String, BdMapperData> sqlMappings = bdConfiguration.getBdMapperRegistory().getSqlMappings();
        BdMapperData bdMapperData = sqlMappings.get(sqlKey);
        if (bdMapperData != null) {
            return bdSqlSession.selectOne(bdMapperData, args);
        }

        return method.invoke(proxy, args);

    }

}
