package com.petroandrushchak.models.domain.listing;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderMethodName = "anAddress", setterPrefix = "with")
public class Address {

    String fullAddress;
    String street;
    String unitNumber;
}
