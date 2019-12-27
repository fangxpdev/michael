package mybatisimpl.excutor;

import mybatisimpl.configuration.BdConfiguration;
import mybatisimpl.configuration.BdDataSource;
import mybatisimpl.mapper.BdMapperData;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BdSimpleExecutor implements BdExecutor {

    private BdConfiguration bdConfiguration;

    public BdSimpleExecutor(BdConfiguration bdConfiguration) {
        this.bdConfiguration = bdConfiguration;
    }

    @Override
    public <E> List<E> execute(BdMapperData bdMapperData, Object[] args) {

        BdDataSource bdDataSource = bdConfiguration.getBdDataSource();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<E> res = new ArrayList<>();
        try {

            Class.forName(bdDataSource.getDriver());
            connection = DriverManager.getConnection(bdDataSource.getUrl(), bdDataSource.getUserName(), bdDataSource.getPassWord());

            String sql = bdMapperData.getSql();

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, (int) args[0]);

            resultSet = preparedStatement.executeQuery();

            //结果处理
            while (resultSet.next()) {

                String resultType = bdMapperData.getResultType();

                Class<?> clazz = Class.forName(resultType);

                Field[] fields = clazz.getDeclaredFields();

                E rs = (E) clazz.newInstance();

                for (int i = 0; i < fields.length; i++) {

                    Field field = fields[i];
                    Class<?> type = field.getType();
                    String name = field.getName();
                    if (int.class.equals(type) || Integer.class.equals(type)) {
                        int r = resultSet.getInt(name);
                        Method method = rs.getClass().getDeclaredMethod("set" + conertName(name), type);
                        method.invoke(rs, r);
                    } else if (String.class.equals(type)) {
                        String r = resultSet.getString(name);
                        Method method = rs.getClass().getDeclaredMethod("set" + conertName(name), type);
                        method.invoke(rs, r);
                    }

                }
                res.add(rs);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            closeResource(resultSet, preparedStatement, connection);
        }


        return res;
    }

    private String conertName(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    private void closeResource(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
