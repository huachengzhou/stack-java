package com.blue.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @Author zch
 * @Description
 * @createDate 2018/12/5
 **/
@ComponentScan("com.blue.spring")
@Configuration
@EnableWebMvc
public class MyMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

    /**
     * 通过注解@Bean 初始化视图解析器
     * @return
     */
    @Bean
    public InternalResourceViewResolver initViewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assembly/**").addResourceLocations("/assembly/**")
                .addResourceLocations("/resources/**").addResourceLocations("/public-resources/");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


}
