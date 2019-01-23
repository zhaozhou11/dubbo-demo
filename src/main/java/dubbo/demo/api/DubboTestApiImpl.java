package dubbo.demo.api;

/**
 * Created by zhaozhou on 2019/1/23.
 */
public class DubboTestApiImpl implements DubboTestApi {

    @Override
    public String echoTest(String msg){
        return msg;
    }
}
