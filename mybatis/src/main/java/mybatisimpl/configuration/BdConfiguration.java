package mybatisimpl.configuration;

import mybatisimpl.mapper.BdMapperRegistory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 全局配置类
 */
public class BdConfiguration {

    //配置
    Properties configProperties = new Properties();

    Properties mapperProperties = new Properties();

    private String configPath;

    private BdDataSource bdDataSource;


    private BdMapperRegistory bdMapperRegistory  ;

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
        bdMapperRegistory = new BdMapperRegistory();
        bdMapperRegistory.loadMapperRegistory(mapperProperties);


    }

    private void scanMapperLocation() {
        String mapperLocation = configProperties.getProperty("mapperLocation");

        if (mapperLocation == null) {
            throw new RuntimeException("mapperLocation is null");
        }

        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(mapperLocation);
        try {
            this.mapperProperties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initDateSource() {

        bdDataSource = new BdDataSource();
        bdDataSource.setDriver(configProperties.getProperty("jdbc.driver"));
        bdDataSource.setUrl(configProperties.getProperty("jdbc.url"));
        bdDataSource.setUserName(configProperties.getProperty("jdbc.userName"));
        bdDataSource.setPassWord(configProperties.getProperty("jdbc.passWord"));

    }

    private void loadProperties() {

        if (this.configPath == null) {
            throw new RuntimeException("配置文件不能为空");
        }

        //1. 加载配置文件
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(configPath);

        try {
            configProperties.load(inputStream);
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

    public BdMapperRegistory getBdMapperRegistory() {
        return bdMapperRegistory;
    }

    public void setBdMapperRegistory(BdMapperRegistory bdMapperRegistory) {
        this.bdMapperRegistory = bdMapperRegistory;
    }
}
