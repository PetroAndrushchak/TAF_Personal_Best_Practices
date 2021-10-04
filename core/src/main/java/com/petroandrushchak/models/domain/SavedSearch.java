package com.petroandrushchak.models.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderMethodName = "aSavedSearch", toBuilder = true, setterPrefix = "with")
public class SavedSearch {

    String name;


}
