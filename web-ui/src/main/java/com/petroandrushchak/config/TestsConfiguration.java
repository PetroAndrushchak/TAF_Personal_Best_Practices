package com.petroandrushchak.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

// This class is used for Spring Configuration approach
@Slf4j
@Data
@Configuration
public class TestsConfiguration {

    @Value("${environment}")
    private String environment;

}
