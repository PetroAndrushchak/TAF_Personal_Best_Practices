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
public class CognitoLoginBody {

    @JsonProperty("AuthParameters")
    AuthParameter authParameters;

    @JsonProperty("AuthFlow")
    String authFlow;

    @JsonProperty("ClientId")
    String clientId;
}
