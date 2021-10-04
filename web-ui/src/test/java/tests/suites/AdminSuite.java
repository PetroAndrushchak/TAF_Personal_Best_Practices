package tests.suites;

import com.petroandrushchak.models.Agent;
import com.petroandrushchak.registry.UserRegistry;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.*;
import tests.exclusive_listings.CreateExclusiveListingTest;

import static tests.metadata.Feature.CREATE_EXCLUSIVE_LISTING;
import static tests.metadata.Story.ADMIN_CREATE_EXCLUSIVE_LISTINGS;

@Suite
@SuiteDisplayName("Test Suite")
@SelectClasses(CreateExclusiveListingTest.class)
public class AdminSuite {
}
