package dubbo.demo.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhaozhou on 2019/1/23.
 */
public class ProviderMain {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config/rpc/dubbo-rpc-provider.xml");
        context.start();
        System.in.read(); // 按任意键退出
    }
}
