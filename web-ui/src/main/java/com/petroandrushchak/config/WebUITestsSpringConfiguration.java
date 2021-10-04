package com.petroandrushchak.config;

import org.aeonbits.owner.ConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;

@Configuration
@EnableRetry
@ComponentScan("com.petroandrushchak")
public class WebUITestsSpringConfiguration {

    @Bean
    public TestsConfigs createTestsConfigs() {
        return ConfigFactory.create(TestsConfigs.class);
    }


}
