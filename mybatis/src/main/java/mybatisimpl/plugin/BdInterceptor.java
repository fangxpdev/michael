package mybatisimpl.plugin;

public interface BdInterceptor {

    Object intercept(Invocation invocation);

    Object Plugin(Object target);
}
