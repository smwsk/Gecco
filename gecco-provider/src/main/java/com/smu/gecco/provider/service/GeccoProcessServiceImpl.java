package com.smu.gecco.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.smu.gecco.service.IGeccoProcessService;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author wangshaokui
 * @version 1.0
 * @className GeccoProcessService
 * @time 2019/1/22 19:46
 **/
@Service(version = "${demo.service.version}")
public class GeccoProcessServiceImpl implements IGeccoProcessService {

    /**
     * The default value of ${dubbo.application.name} is ${spring.application.name}
     */
    @Value("${spring.application.name}")
    private String serviceName;

    public String sayHello(String name) {
        return String.format("[%s] : Hello, %s", serviceName, name);
    }

}
