package com.petroandrushchak.models.domain;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;

import static com.petroandrushchak.models.domain.listing.Addresses.uniqueAddress;
import static com.petroandrushchak.models.domain.listing.ListingStatus.ACTIVE;
import static com.petroandrushchak.models.domain.listing.PropertyType.HOME;

@UtilityClass
public class ExclusiveListings {

    public static ExclusiveListing defaultExclusiveListing() {
        return anExclusiveListing().build();
    }

    public static ExclusiveListing.ExclusiveListingBuilder anExclusiveListing() {
        return ExclusiveListing.anExclusiveListing()
                .withExpirationDate(LocalDate.now().plusDays(10))
                .withMlsTargetDate(LocalDate.now().plusDays(15))
                .withPropertyType(HOME)
                .withStatus(ACTIVE)
                .withAddress(uniqueAddress());
    }
}
