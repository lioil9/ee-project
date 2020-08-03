package club.banyuan.controller;

import club.banyuan.config.CustomConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomConfigController {

    @Autowired
    private CustomConfig customConfig;

    @RequestMapping("/custom")
    public String custom(){
        return "读取到自定义配置 custom.username 内容为：" + customConfig.getUsername();
    }

}
