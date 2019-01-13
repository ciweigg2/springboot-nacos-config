package com.example.springbootnacosconfig;

import com.alibaba.nacos.api.config.annotation.NacosConfigListener;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosController {

    @NacosValue(value = "${name:unknown}" ,autoRefreshed = true)
    private String name;

    @Autowired
    private User user;

    @RequestMapping(value = "/sayHello")
    public String dubboSayHello(){
        System.out.println(name);
        return name;
    }

    //监听nacos配置文件的变化
    @NacosConfigListener(
            dataId = "nacos_config",
            groupId = "nacos_group",
            timeout = 500
    )
    public void onChange(String newContent) throws Exception {
        System.out.println("onChange : " + newContent);
    }

    @NacosConfigListener(
            dataId = "nacos_config2",
            groupId = "nacos_group",
            timeout = 500
    )
    public void onChange2(String newContent) throws Exception {
        System.out.println("onChange : " + newContent);
    }

}
