package com.petroandrushchak.spring.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.petroandrushchak"})
public class WebClientSpringConfiguration {

    public final String DEFAULT_ENV = "test";


}
