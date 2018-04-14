package com.light.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

/**
 * 通过注解配置factory-class
 * @author xiaowen
 * @date 2016年5月30日
 * @ version 1.0
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.light.core.repository")
@EnableSpringDataWebSupport
public class JpaDataConfig {
}
