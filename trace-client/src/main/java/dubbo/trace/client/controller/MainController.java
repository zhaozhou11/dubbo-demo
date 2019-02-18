package dubbo.trace.client.controller;


import dubbo.trace.server.api.DubboTraceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhaozhou on 2019/2/14.
 */
@Controller
@RequestMapping(value = "")
public class MainController {

    @Autowired
    private DubboTraceApi traceApi;

    @RequestMapping(value = "/")
    public String gotoIndexPage(Model model){
        String ret = traceApi.echoTest("this is test!");
        model.addAttribute("ret", ret);
        return "index";
    }
}
