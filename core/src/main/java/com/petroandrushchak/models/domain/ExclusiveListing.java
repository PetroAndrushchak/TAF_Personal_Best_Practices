package com.petroandrushchak.models.domain;

import com.petroandrushchak.models.domain.listing.Address;
import com.petroandrushchak.models.domain.listing.ListingStatus;
import com.petroandrushchak.models.domain.listing.PropertyType;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

import static com.petroandrushchak.models.domain.listing.ListingStatus.SOLD;

@Data
@Builder(builderMethodName = "anExclusiveListing", toBuilder = true, setterPrefix = "with")
public class ExclusiveListing {

    LocalDate expirationDate;
    LocalDate mlsTargetDate;

    ListingStatus status;
    PropertyType propertyType;

    Address address;

    public static void main(String[] args) {

       ExclusiveListing defaultExclusiveListing = ExclusiveListings.defaultExclusiveListing();

       ExclusiveListing soldExclusiveListing = ExclusiveListings.anExclusiveListing()
               .withStatus(SOLD)
               .build();

       SavedSearch savedSearch = SavedSearches.defaultSavedSearch();
    }

}
