package com.petroandrushchak.client;

import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.slf4j.Slf4jLogger;

public class ApiClient {

    private Logger.Level level;

    public ApiClient(Logger.Level level) {
        this.level = level;
    }

    Feign.Builder createBaseFeignBuilder() {
        return Feign.builder()
                .logger(new Slf4jLogger())
                .logLevel(level)
                .decoder(new JacksonDecoder());
    }

}
