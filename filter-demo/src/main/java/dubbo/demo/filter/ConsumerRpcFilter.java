package dubbo.demo.filter;


import com.alibaba.dubbo.rpc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zhaozhou on 2019/2/14.
 */
public class ConsumerRpcFilter implements Filter {

    private static Logger logger = LoggerFactory.getLogger(ConsumerRpcFilter.class);

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        logger.info("className:{}", invocation.getClass().getName());
        logger.info("methodName:{}", invocation.getMethodName());
        String appCode = invoker.getUrl().getParameter("appCode");
        String secretKey = invoker.getUrl().getParameter("secretKey");

        RpcContext.getContext().setAttachment("appCode",appCode);
        RpcContext.getContext().setAttachment("secretKey", secretKey);
        return invoker.invoke(invocation);
    }
}
