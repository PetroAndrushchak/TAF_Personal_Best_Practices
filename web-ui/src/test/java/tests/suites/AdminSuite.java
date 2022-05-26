package tests.suites;

import org.junit.platform.suite.api.*;
import tests.ra.exclusive_listings.CreateExclusiveListingTest;

@Suite
@SuiteDisplayName("Test Suite")
@SelectClasses(CreateExclusiveListingTest.class)
public class AdminSuite {
}
