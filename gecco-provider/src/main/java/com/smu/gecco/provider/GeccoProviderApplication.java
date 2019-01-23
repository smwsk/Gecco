package com.smu.gecco.provider;


import com.smu.gecco.provider.config.EmbeddedZooKeeper;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;

@EnableAutoConfiguration
public class GeccoProviderApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(GeccoProviderApplication.class)
                .web(WebApplicationType.NONE)
                .listeners((ApplicationListener<ApplicationEnvironmentPreparedEvent>) event -> {
                    org.springframework.core.env.Environment environment = event.getEnvironment();
                    int port = environment.getProperty("embedded.zookeeper.port", int.class);
                    new EmbeddedZooKeeper(port, false).start();
                }).run(args);
    }

}

