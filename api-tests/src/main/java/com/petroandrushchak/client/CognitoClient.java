package com.petroandrushchak.client;

import com.petroandrushchak.client.base.ICognitoClient;
import com.petroandrushchak.client.cognito.dto.AuthParameter;
import com.petroandrushchak.client.cognito.dto.CognitoLoginBody;
import com.petroandrushchak.client.cognito.dto.CognitoLoginResponse;
import com.petroandrushchak.model.User;
import feign.Contract;
import feign.Logger;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@Import(FeignClientsConfiguration.class)
@Component
public class CognitoClient extends ApiClient {

    private ICognitoClient cognitoClient;

    @Autowired
    public CognitoClient(Decoder decoder, Encoder encoder, Contract contract, Logger.Level level) {
        super(level);
        this.cognitoClient = createBaseFeignBuilder()
                .encoder(new JacksonEncoder())
                .target(ICognitoClient.class, "https://cognito-idp.us-east-1.amazonaws.com");
    }

    public void login(User user) {
        AuthParameter authParameters = AuthParameter.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .build();
        CognitoLoginBody cognitoLoginRqDto = CognitoLoginBody.builder()
                .authParameters(authParameters)
                .authFlow("USER_PASSWORD_AUTH")
                .clientId("1f3a4744u58gmo57sm9q300ksn")
                .build();
        CognitoLoginResponse response = cognitoClient.authenticate(cognitoLoginRqDto);
    }

}
