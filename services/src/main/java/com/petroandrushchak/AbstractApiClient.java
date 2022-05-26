package com.petroandrushchak;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriBuilderFactory;

import java.util.function.Consumer;

public interface AbstractApiClient {

    default ExchangeStrategies createExchangeStrategies() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return ExchangeStrategies.builder()
                .codecs(config -> config.defaultCodecs().jackson2JsonDecoder(new Jackson2JsonDecoder(mapper)))
                .build();
    }

    default Consumer<HttpHeaders> createHeaders() {
        return httpHeaders -> {
            httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        };
    }

    default UriBuilderFactory createUriBuilderFactory(@NonNull final String baseURL) {
        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(baseURL);
        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.NONE);
        return factory;
    }

    default WebClient createWebClient(@NonNull final String baseURL) {
        ExchangeStrategies exchangeStrategies = createExchangeStrategies();

        return WebClient.builder()
                .exchangeStrategies(exchangeStrategies)
                .uriBuilderFactory(createUriBuilderFactory(baseURL))
                .defaultHeaders(createHeaders())
                .clientConnector(WebClientFilter.getClientResponseFilter())
                .build();
    }
}
