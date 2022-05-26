package com.petroandrushchak.client.cognito.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

@Builder
@FieldDefaults(level = AccessLevel.PUBLIC)
public class AuthParameter {

    @JsonProperty("USERNAME")
    String username;

    @JsonProperty("PASSWORD")
    String password;

    @JsonProperty("REFRESH_TOKEN")
    String refreshToken;
}