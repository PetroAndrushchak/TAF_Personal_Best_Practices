package tests.suites;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import tests.exclusive_listings.CreateExclusiveListingTest;

@RunWith(JUnitPlatform.class)
@SelectClasses(CreateExclusiveListingTest.class)
@IncludeTags("mobile")
public class SecondSuite {
}