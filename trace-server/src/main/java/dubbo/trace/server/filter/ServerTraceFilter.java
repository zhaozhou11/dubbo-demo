package dubbo.trace.server.filter;


import com.alibaba.dubbo.rpc.*;
import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.UUID;

/**
 * Created by zhaozhou on 2019/2/14.
 */
public class ServerTraceFilter implements Filter {

    private static Logger logger = LoggerFactory.getLogger(ServerTraceFilter.class);

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        logger.info("####className:{}", invocation.getClass().getName());
        logger.info("####methodName:{}", invocation.getMethodName());

        //获取appCode及secretKey
        String appCode = RpcContext.getContext().getAttachment("appCode");
        String secretKey = RpcContext.getContext().getAttachment("secretKey");

        if(Strings.isNullOrEmpty(appCode) || Strings.isNullOrEmpty(secretKey)){
            throw new RpcException("Sorry, your access is denied!");
        }

        logger.info("appCode:{}", appCode);

        //获取reqId，若没有，则通过UUID生成一个；然后将reqId放到MDC中，便于日志中打印
        String reqId = RpcContext.getContext().getAttachment("reqId");
        reqId = !Strings.isNullOrEmpty(reqId) ? reqId : UUID.randomUUID().toString();
        MDC.put("appCode", appCode);
        MDC.put("reqId", reqId);

        logger.info("reqId:{}", reqId);
        if(!appCode.equals("zhaozhou11") || !secretKey.equals("666666")){
            throw new RpcException("your appCode or secretKey is error!");
        }

        return invoker.invoke(invocation);
    }
}
