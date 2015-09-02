package com.webnovelscrossroads.config.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@ComponentScan(basePackages="com.webnovelscrossroads")
@Configuration
@Import({WebConfig.class, DatasourceConfig.class, SecurityConfig.class})
public class RootConfig {
}