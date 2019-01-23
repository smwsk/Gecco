package com.smu.gecco.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.smu.gecco.service.IGeccoProcessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;

@EnableAutoConfiguration
public class GeccoConsumerApplication {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Reference(version = "${demo.service.version}")
    private IGeccoProcessService geccoProcessService;

    @Bean
    public ApplicationRunner runner() {
        return args -> {
            logger.info(geccoProcessService.sayHello("mercyblitz"));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(GeccoConsumerApplication.class).close();
    }
}

