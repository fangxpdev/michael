package mybatisimpl.mapper;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BdMapperRegistory {

    public static final Map<String, BdMapperData> sqlMappings = new HashMap<>();

    public void loadMapperRegistory(Properties properties) {

        Enumeration<?> propertyNames = properties.propertyNames();

        while (propertyNames.hasMoreElements()) {

            String key = (String) propertyNames.nextElement();

            String content = properties.getProperty(key);

            String[] sqlContent = content.split("#");

            String sql = sqlContent[0];
//            String parameterType =

//            BdMapperData bdMapperData = new BdMapperData();




        }

    }


}
