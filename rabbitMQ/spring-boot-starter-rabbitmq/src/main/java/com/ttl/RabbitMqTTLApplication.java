package com.ttl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@ServletComponentScan
@EnableAsync
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class RabbitMqTTLApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqTTLApplication.class, args);
    }

    @Bean
    public TomcatServletWebServerFactory servletContainer(){
        TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory();
        tomcatServletWebServerFactory.setPort(18888);
        tomcatServletWebServerFactory.setContextPath("/rabbitmq");
        return tomcatServletWebServerFactory;
    }
}
