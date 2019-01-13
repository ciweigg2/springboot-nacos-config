package com.example.springbootnacosconfig;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.springframework.core.env.StandardEnvironment.SYSTEM_ENVIRONMENT_PROPERTY_SOURCE_NAME;
import static org.springframework.core.env.StandardEnvironment.SYSTEM_PROPERTIES_PROPERTY_SOURCE_NAME;

@EnableAutoConfiguration
@SpringBootApplication
@NacosPropertySource(
        name = "custom",
        dataId = "nacos_config",
        first = true,
        groupId = "nacos_group",
        autoRefreshed = true, //自动刷新
        before = SYSTEM_PROPERTIES_PROPERTY_SOURCE_NAME,
        after = SYSTEM_ENVIRONMENT_PROPERTY_SOURCE_NAME
)
public class SpringbootNacosConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootNacosConfigApplication.class, args);
    }

}

