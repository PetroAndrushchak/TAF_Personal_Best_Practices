package tests.suites;

import org.junit.platform.suite.api.*;
import tests.exclusive_listings.CreateExclusiveListingTest;

import static tests.metadata.Feature.CREATE_EXCLUSIVE_LISTING;
import static tests.metadata.Story.ADMIN_CREATE_EXCLUSIVE_LISTINGS;

@Suite
@SuiteDisplayName("Test Suite")
@SelectClasses(CreateExclusiveListingTest.class)
public class AdminSuite {
}
