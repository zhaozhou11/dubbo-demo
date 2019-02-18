package dubbo.demo.filter;

import com.alibaba.dubbo.rpc.*;
import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zhaozhou on 2019/2/14.
 */
public class ProviderRpcFilter implements Filter{

    private static Logger logger = LoggerFactory.getLogger(ProviderRpcFilter.class);

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        logger.info("className:{}", invocation.getClass().getName());
        logger.info("methodName:{}", invocation.getMethodName());

        String appCode = RpcContext.getContext().getAttachment("appCode");
        String secretKey = RpcContext.getContext().getAttachment("secretKey");

        if(!Strings.isNullOrEmpty(appCode) || !Strings.isNullOrEmpty(secretKey)){
            throw new RpcException("Sorry, your access is denied!");
        }

        logger.info("appCode:{}", appCode);

        if(!appCode.equals("zhaozhou11") || !secretKey.equals("666666")){
            throw new RpcException("your appCode or secretKey is error!");
        }

        return invoker.invoke(invocation);
    }
}
