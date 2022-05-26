package com.petroandrushchak.client;

import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.slf4j.Slf4jLogger;

public abstract class AuthApiClient {

    private Logger.Level level;

    public AuthApiClient(Logger.Level level) {
        this.level = level;
    }

    Feign.Builder createBaseFeignBuilder() {
        return Feign.builder()
                .logger(new Slf4jLogger())
                .requestInterceptor(new Auth0RequestInterceptor())
                .logLevel(level)
                .decoder(new JacksonDecoder());
    }

}
