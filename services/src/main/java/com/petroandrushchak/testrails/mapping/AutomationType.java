package com.petroandrushchak.testrails.mapping;

public enum AutomationType {

    NONE(0),
    PARTIALLY_AUTOMATED(1),
    AUTOMATED(2),
    WONT_BE_AUTOMATED(3),
    PLANNED(4);

    int testRailsId;

    AutomationType(int testRailsId) {
        this.testRailsId = testRailsId;
    }
}
