package mybatisimpl.mapper;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BdMapperRegistory {

    private final Map<String, BdMapperData> sqlMappings = new HashMap<>();

    public void loadMapperRegistory(Properties properties) {

        Enumeration<?> propertyNames = properties.propertyNames();

        while (propertyNames.hasMoreElements()) {

            String key = (String) propertyNames.nextElement();

            String content = properties.getProperty(key);

            String[] sqlContent = content.split("#");

            String sql = sqlContent[0];
            String resultType = sqlContent[1];

            BdMapperData bdMapperData = new BdMapperData(sql, resultType, null);

            sqlMappings.put(key, bdMapperData);

        }

    }

    public Map<String, BdMapperData> getSqlMappings() {
        return sqlMappings;
    }
}
