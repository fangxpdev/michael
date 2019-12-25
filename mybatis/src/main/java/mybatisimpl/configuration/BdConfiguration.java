package mybatisimpl.configuration;

import mybatisimpl.excutor.BdExecutor;
import mybatisimpl.excutor.BdSimpleExcutor;
import mybatisimpl.mapper.BdMapperData;
import mybatisimpl.mapper.BdMapperRegistory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 全局配置类
 */
public class BdConfiguration {

    //配置
    Properties properties = new Properties();

    private String configPath;

    private BdDataSource bdDataSource;

    private BdExecutor bdExecutor = new BdSimpleExcutor();

    private BdMapperRegistory bdMapperRegistory;

    public BdConfiguration(String configPath) {
        this.configPath = configPath;
        init();
    }

    private void init() {

        //1. 配置文件读取
        loadProperties();

        //2. 数据源信息初始化
        initDateSource();

        //3. mapper
        loadMapperRegistory();


    }

    private void loadMapperRegistory() {
        scanMapperLocation();

        bdMapperRegistory.loadMapperRegistory(properties);


    }

    private void scanMapperLocation() {
        String mapperLocation = properties.getProperty("mapperLocation");

        if (mapperLocation == null) {
            throw new RuntimeException("mapperLocation is null");
        }

        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(mapperLocation);
        try {
            this.properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initDateSource() {

        bdDataSource = new BdDataSource();
        bdDataSource.setDriver(properties.getProperty("jdbc.driver"));
        bdDataSource.setUrl(properties.getProperty("jdbc.url"));
        bdDataSource.setUserName(properties.getProperty("jdbc.username"));
        bdDataSource.setPassWord(properties.getProperty("jdbc.password"));

    }

    private void loadProperties() {

        if (this.configPath == null) {
            throw new RuntimeException("配置文件不能为空");
        }

        //1. 加载配置文件
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(configPath);

        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public BdDataSource getBdDataSource() {
        return bdDataSource;
    }

    public void setBdDataSource(BdDataSource bdDataSource) {
        this.bdDataSource = bdDataSource;
    }

    public BdExecutor getBdExecutor() {
        return bdExecutor;
    }

    public void setBdExecutor(BdExecutor bdExecutor) {
        this.bdExecutor = bdExecutor;
    }
}
