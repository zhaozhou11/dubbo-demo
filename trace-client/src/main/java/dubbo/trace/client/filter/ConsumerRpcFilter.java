package dubbo.trace.client.filter;


import com.alibaba.dubbo.rpc.*;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.UUID;

/**
 * Created by zhaozhou on 2019/2/14.
 */
public class ConsumerRpcFilter implements Filter {

    private static Logger logger = LoggerFactory.getLogger(ConsumerRpcFilter.class);

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        logger.info("###className:{}", invocation.getClass().getName());
        logger.info("###methodName:{}", invocation.getMethodName());
        String appCode = invoker.getUrl().getParameter("appCode");
        String secretKey = invoker.getUrl().getParameter("secretKey");

        String reqId = MDC.get("reqId");
        reqId = Strings.isNotEmpty(reqId) ? reqId : UUID.randomUUID().toString();

        RpcContext.getContext().setAttachment("appCode",appCode);
        RpcContext.getContext().setAttachment("secretKey", secretKey);
        RpcContext.getContext().setAttachment("reqId", reqId);
        return invoker.invoke(invocation);
    }
}
