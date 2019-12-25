package mybatisimpl.mapper;

public class BdMapperData {

    private String sql;

    private String resultType;

    private String parameterType;

    public BdMapperData(String sql, String resultType, String parameterType) {
        this.sql = sql;
        this.resultType = resultType;
        this.parameterType = parameterType;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(String parameterType) {
        this.parameterType = parameterType;
    }
}
