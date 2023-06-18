package com.gold.tree;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
//定义jpa实体扫描包
@EntityScan(basePackages = {"com.jpa.entity"})
//定义jpa接口扫描包
@EnableJpaRepositories(basePackages = {"com.jpa.dao"})
@MapperScan(basePackages = {"com.gold.dal.mapper"})
@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class},scanBasePackages = {"com.gold" ,"com.jpa.service" } )
public class JsTreeApplication {

    public static void main(String[] args) {
        SpringApplication.run(JsTreeApplication.class, args);
    }

}
