package com.blue.spring.web;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @createDate 2018/12/11
 **/
@EnableWebMvc
@Configuration
public class ThymeleafConfig extends WebMvcConfigurerAdapter {

    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setOrder(100);
        return viewResolver;
    }

    @Bean(value = "thymeleafViewResolver")
    public org.thymeleaf.spring4.view.ThymeleafViewResolver getThymeleafViewResolver(@Qualifier(value = "springTemplateEngine") org.thymeleaf.spring4.SpringTemplateEngine templateEngine){
        org.thymeleaf.spring4.view.ThymeleafViewResolver viewResolver = new org.thymeleaf.spring4.view.ThymeleafViewResolver();
        viewResolver.setOrder(1);
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setCache(false);
        viewResolver.setTemplateEngine(templateEngine);
        return viewResolver;
    }

    @Bean(value = "springTemplateEngine")
    public org.thymeleaf.spring4.SpringTemplateEngine getSpringTemplateEngine(@Qualifier(value = "springResourceTemplateResolver") org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver templateResolver){
        org.thymeleaf.spring4.SpringTemplateEngine springTemplateEngine = new org.thymeleaf.spring4.SpringTemplateEngine();
        springTemplateEngine.setTemplateResolver(templateResolver);
        return springTemplateEngine;
    }

    @Bean(value = "springResourceTemplateResolver")
    public org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver getTemplateResolver(){
        org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver templateResolver = new org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver();
        templateResolver.setPrefix("/");
        templateResolver.setSuffix(".html");
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setTemplateMode("HTML5");
        templateResolver.setCacheable(false);
        return templateResolver;
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
