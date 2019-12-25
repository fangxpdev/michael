package mybatisimpl.session;

import mybatisimpl.configuration.BdConfiguration;

public class BdSqlSessionFactoryBuilder {

    private BdConfiguration bdConfiguration;

    public BdSqlSessionFactoryBuilder(BdConfiguration bdConfiguration) {
        this.bdConfiguration = bdConfiguration;
    }

    public BdSqlSessionFactory build() {
        return new BdSqlSessionFactory(bdConfiguration);
    }

}
