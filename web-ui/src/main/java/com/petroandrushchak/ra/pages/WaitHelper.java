package com.petroandrushchak.ra.pages;

import java.util.Arrays;
import java.util.function.BooleanSupplier;

import static java.time.Duration.ofSeconds;
import static org.awaitility.Awaitility.await;

public class WaitHelper {

    public void waitUntilOneOfConditionsMatch(BooleanSupplier ... conditions) {
        await().timeout(ofSeconds(20))
                .pollInterval(ofSeconds(1))
                .until(() -> Arrays.stream(conditions).anyMatch(BooleanSupplier::getAsBoolean));
    }

    public static void main(String[] args) {
        BuyPage buyPage = new BuyPage();
        new WaitHelper().waitUntilOneOfConditionsMatch(
                buyPage::areListingsLoaded,
                buyPage::isNotResultPresent
        );
    }


}
