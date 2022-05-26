package com.petroandrushchak.client.base;

import com.petroandrushchak.client.cognito.dto.CognitoLoginBody;
import com.petroandrushchak.client.cognito.dto.CognitoLoginResponse;
import feign.Headers;
import feign.RequestLine;
import feign.Response;
import org.springframework.web.bind.annotation.RequestBody;

public interface ICognitoClient {

    @RequestLine("POST /api")
    @Headers({
            "X-AMZ-TARGET: AWSCognitoIdentityProviderService.InitiateAuth",
            "Accept: */*",
            "Content-Type: application/x-amz-json-1.1; charset=ISO-8859-1"
    })
    CognitoLoginResponse authenticate(@RequestBody final CognitoLoginBody body);
}
