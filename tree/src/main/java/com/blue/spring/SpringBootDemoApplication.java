package com.blue.spring;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author noatn
 * @Description
 * @createDate 2018/10/24
 **/
@SpringBootApplication
@ComponentScan(basePackages = {"com.blue"})
@MapperScan(basePackages = {"com.blue.dal.mapper.custom","com.blue.dal.mapper"})
public class SpringBootDemoApplication extends SpringBootServletInitializer {

    private static final Logger logger = LoggerFactory.getLogger(SpringBootDemoApplication.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringBootDemoApplication.class);
    }


    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication();
        springApplication.setBannerMode(Banner.Mode.CONSOLE);
        logger.info("run");
        springApplication.run(SpringBootDemoApplication.class, args);
    }

}
