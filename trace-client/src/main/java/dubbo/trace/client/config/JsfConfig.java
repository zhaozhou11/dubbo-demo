package dubbo.trace.client.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by zhaozhou on 2018/11/7.
 */
@Configuration
@ImportResource(locations = {"classpath:config/rpc/dubbo-rpc-consumer.xml"})
public class JsfConfig {
}
