package com.paper.question.web.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.paper.question.dao.mapper"})
public class MybatisMapperConfig {

}
