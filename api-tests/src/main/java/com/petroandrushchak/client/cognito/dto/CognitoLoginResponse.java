package com.petroandrushchak.client.cognito.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class CognitoLoginResponse {

    @JsonProperty("AuthenticationResult")
    AuthenticationResultDto authenticationResultDto;


    @AllArgsConstructor
    @NoArgsConstructor
    @FieldDefaults(level = AccessLevel.PUBLIC)
    public class AuthenticationResultDto {

        @JsonProperty("AccessToken")
        String accessToken;

        @JsonProperty("ExpiresIn")
        Integer expiresIn;

        @JsonProperty("IdToken")
        String idToken;

        @JsonProperty("RefreshToken")
        String refreshToken;

        @JsonProperty("TokenType")
        String tokenType;
    }
}
