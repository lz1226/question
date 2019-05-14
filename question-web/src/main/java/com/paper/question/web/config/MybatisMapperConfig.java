package com.paper.question.web.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan({"com.paper.question.dao.mapper"})
public class MybatisMapperConfig {
    @Bean
    public void aa() {
//        E:\paperSys\question\question-dao\src\main\java\com\paper\question\dao\mapper
        System.out.println("走了");
    }
}

