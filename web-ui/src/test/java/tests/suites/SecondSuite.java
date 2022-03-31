package tests.suites;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;
import tests.exclusive_listings.CreateExclusiveListingTest;

@Suite
@SuiteDisplayName("Test Suite Two")
@SelectClasses(CreateExclusiveListingTest.class)
@IncludeTags("mobile")
public class SecondSuite {
}