package com.petroandrushchak.models.domain;

import lombok.experimental.UtilityClass;

@UtilityClass
public class SavedSearches {

    public static SavedSearch defaultSavedSearch() {
        return anSavedSearch().build();
    }

    public static SavedSearch.SavedSearchBuilder anSavedSearch() {
        return SavedSearch.aSavedSearch().withName("RandomSavedSearchName");
    }


}
