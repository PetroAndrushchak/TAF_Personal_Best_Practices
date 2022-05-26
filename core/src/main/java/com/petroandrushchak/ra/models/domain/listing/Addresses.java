package com.petroandrushchak.ra.models.domain.listing;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Addresses {

    public static Address uniqueAddress(){
        //TODO We need to generate an unique address for the new exclusive listings
        String fullAddress = ""; //Call to the AddressRegistry for generating
        return Address.anAddress().withFullAddress(fullAddress).build();
    }
}
