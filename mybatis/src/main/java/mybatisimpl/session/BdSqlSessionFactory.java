package mybatisimpl.session;

import mybatisimpl.configuration.BdConfiguration;

/**
 * sqlSession工厂
 */
public class BdSqlSessionFactory {

    private BdConfiguration bdConfiguration;

    public BdSqlSessionFactory(BdConfiguration bdConfiguration) {
        this.bdConfiguration = bdConfiguration;
    }


    public BdSqlSession openSession() {
        return new BdSqlSession(bdConfiguration);
    }
}
