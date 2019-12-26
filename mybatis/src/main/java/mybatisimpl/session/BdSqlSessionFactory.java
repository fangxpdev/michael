package mybatisimpl.session;

import mybatisimpl.configuration.BdConfiguration;
import mybatisimpl.excutor.BdExecutor;
import mybatisimpl.excutor.BdSimpleExecutor;

/**
 * sqlSession工厂
 */
public class BdSqlSessionFactory {

    private BdConfiguration bdConfiguration;

    public BdSqlSessionFactory(BdConfiguration bdConfiguration) {
        this.bdConfiguration = bdConfiguration;
    }


    public BdSqlSession openSession() {

        BdExecutor bdExecutor = new BdSimpleExecutor(bdConfiguration);

        return new BdSqlSession(bdConfiguration, bdExecutor);
    }
}
