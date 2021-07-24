package com.petroandrushchak.testrails;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.petroandrushchak.AbstractApiClient;
import com.petroandrushchak.WebClientFilter;
import com.petroandrushchak.testrails.modals.RealtyAustinTestCase;
import com.petroandrushchak.testrails.modals.TestCase;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.function.Consumer;

public class TestRailsClient implements AbstractApiClient {

    private WebClient webClient;

    private String username;
    private String password;

    public TestRailsClient(Builder builder) {
        this.username = builder.username;
        this.password = builder.password;
        webClient = createWebClient(builder.host);
    }

    public List<RealtyAustinTestCase> getAllTestCasesForProject(String projectId){
        String path = "/index.php?/api/v2/get_cases/" + projectId;

        List<RealtyAustinTestCase> testCase = webClient.get()
                .uri(path)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<RealtyAustinTestCase>>() {}).block();

        System.out.println("dsfsdf");
        return testCase;
    }

    public TestCase getTestCaseById(String id){
        String path = "/index.php?/api/v2/get_case/" + id;

        TestCase testCase = webClient.get()
                .uri(path)
                .retrieve()
                .bodyToMono(TestCase.class).block();

        return testCase;
    }

    @Override
    public Consumer<HttpHeaders> createHeaders() {
        Consumer<HttpHeaders> headers = AbstractApiClient.super.createHeaders();
        return headers.andThen(header -> header.setBasicAuth(username, password));
    }

    @Override
    public ExchangeStrategies createExchangeStrategies() {
        ExchangeStrategies exchangeStrategies = AbstractApiClient.super.createExchangeStrategies();
        return exchangeStrategies.mutate().codecs(configurer -> configurer
                .defaultCodecs()
                .maxInMemorySize(16 * 1024 * 1024))
                .build();
    }

    public static class Builder {

        private final String host;
        private final String username;
        private final String password;

        public Builder(final String host, final String username, final String password) {
            this.host = host;
            this.username = username;
            this.password = password;
        }

        public TestRailsClient build() {
            return new TestRailsClient(this);
        }

    }

    public static void main(String[] args) {
        TestRailsClient testRailsClient =  new TestRailsClient.Builder("https://radev.testrail.io", "pandr@softserveinc.com", "5q42j1V1o75F").build();
        testRailsClient.getAllTestCasesForProject("1");
    }

}
