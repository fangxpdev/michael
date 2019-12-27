package mybatisimpl.plugin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 拦截器链
 */
public class BdInterceptorChain {

    private List<BdInterceptor> interceptorList = new ArrayList<>();

    public Object pluginAll(Object target) {
        for (BdInterceptor bdInterceptor : interceptorList) {
            target = bdInterceptor.Plugin(target);
        }
        return target;
    }

    public void addInterceptor(BdInterceptor interceptor) {
        interceptorList.add(interceptor);
    }

    public List<BdInterceptor> getInterceptors() {
        return Collections.unmodifiableList(interceptorList);
    }

}
