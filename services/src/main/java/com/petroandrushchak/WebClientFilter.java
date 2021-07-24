package com.petroandrushchak;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.http.HttpField;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.springframework.http.client.reactive.JettyClientHttpConnector;

import java.net.URI;
import java.nio.charset.StandardCharsets;

@Slf4j
public class WebClientFilter {

    public static JettyClientHttpConnector getClientResponseFilter(){
        SslContextFactory.Client sslContextFactory = new SslContextFactory.Client();
        org.eclipse.jetty.client.HttpClient httpClient = new org.eclipse.jetty.client.HttpClient(sslContextFactory) {
            @Override
            public Request newRequest(URI uri) {
                Request request = super.newRequest(uri);
                return filterRequest(request);
            }
        };
        return new JettyClientHttpConnector(httpClient);
    }

    private static Request filterRequest(Request request) {

        request.onRequestBegin( theRequest -> {
            log.info(theRequest.getMethod() + " to " + theRequest.getURI());
        });

        request.onRequestHeaders(theRequest -> {
            log.info("Request Headers: ");
            for (HttpField header : theRequest.getHeaders()) {
                logNameAndValuePair(header.getName(), header.getValue());
            }
        });

        request.onResponseBegin( theResponse -> {
            log.info("Response Status code {} ({})", theResponse.getStatus(), theResponse.getReason());
        });

        request.onResponseHeaders(theResponse -> {
            log.info("Response Headers: ");
            for (HttpField header : theResponse.getHeaders()) {
                logNameAndValuePair(header.getName(), header.getValue());
            }
        });

        request.onResponseContent((theResponse, content) -> {
            log.info("Body is {} ", StandardCharsets.UTF_8.decode(content));
        });

        return request;
    }

    private static void logNameAndValuePair(String name, String value) {
        log.info("{}={}", name, value);
    }
}
