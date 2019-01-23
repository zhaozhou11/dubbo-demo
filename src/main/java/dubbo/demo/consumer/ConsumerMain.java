package dubbo.demo.consumer;

import dubbo.demo.api.DubboTestApi;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhaozhou on 2019/1/23.
 */
public class ConsumerMain {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config/rpc/dubbo-rpc-consumer.xml");
        context.start();
        DubboTestApi testApi = (DubboTestApi) context.getBean("dubboTestApi"); // 获取远程服务代理
        String ret = testApi.echoTest("this is my test!");
        System.out.println(ret); // 显示调用结果
        System.in.read();
    }
}
