package mybatisimpl.configuration;

import mybatisimpl.excutor.BdExecutor;
import mybatisimpl.excutor.BdSimpleExecutor;
import mybatisimpl.mapper.BdMapperRegistory;
import mybatisimpl.plugin.BdInterceptor;
import mybatisimpl.plugin.BdInterceptorChain;

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

    /**
     * 配置文件位置
     */
    private String configPath;

    /**
     * 数据源配置
     */
    private BdDataSource bdDataSource;

    /**
     * mapper缓存
     */
    private BdMapperRegistory bdMapperRegistory;

    /**
     * 拦截器链
     */
    private BdInterceptorChain bdInterceptorChain = new BdInterceptorChain();

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

        //3.加载plugin
        loadInterceptor();


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

    private void loadInterceptor() {

        String inter = configProperties.getProperty("intercepters");
        if (inter != null) {
            String[] interceptors = inter.split(",");
            for (String interceptor : interceptors) {

                try {
                    Class<?> clazz = Class.forName(interceptor);
                    bdInterceptorChain.addInterceptor((BdInterceptor) clazz.newInstance());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }

    }


    public BdExecutor newExecutor() {

        BdExecutor executor = new BdSimpleExecutor(this);

        return (BdExecutor) bdInterceptorChain.pluginAll(executor);
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

    public BdInterceptorChain getBdInterceptorChain() {
        return bdInterceptorChain;
    }

    public void setBdInterceptorChain(BdInterceptorChain bdInterceptorChain) {
        this.bdInterceptorChain = bdInterceptorChain;
    }
}
