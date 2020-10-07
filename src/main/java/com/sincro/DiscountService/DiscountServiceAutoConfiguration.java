package com.sincro.DiscountService;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories("com.sincro.DiscountService.impl.*")
@EnableTransactionManagement
@EntityScan
@ComponentScan(basePackages = {"com.sincro.DiscountService"})
public class DiscountServiceAutoConfiguration {


}
