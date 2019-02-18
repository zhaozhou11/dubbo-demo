package dubbo.trace.server.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zhaozhou on 2019/1/23.
 */
public class DubboTraceApiImpl implements DubboTraceApi {

    private static Logger logger = LoggerFactory.getLogger(DubboTraceApiImpl.class);

    @Override
    public String echoTest(String msg){
        logger.info("echoTest:{}", msg);
        return msg;
    }
}
