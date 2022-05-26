package com.petroandrushchak.ra.pages;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BuyPage  {

    public boolean areListingsLoaded() {
        log.info("Checking if Listings are loaded");
        return false;
    }

    public boolean isNotResultPresent() {
        log.info("Checking if Not Result label is present");
        return false;
    }

}
