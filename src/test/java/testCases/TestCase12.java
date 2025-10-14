package testCases;
// A cleaner version of writing scripts using separate Base Test. Verify user login via BaseTest

import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HRMLoginPage;

public class TestCase12 extends BaseTest {

    @Test
    public void TC12() throws InterruptedException {

        ExtentTest testLogger = getExtent().createTest("TestCase_012");
        setTest(testLogger);

        testLogger.info("Verify user login via Base Test 12");

        boolean userTextBoxPresent = seleniumUtils.isElementPresent(HRMLoginPage.userNameTextbox);
        System.out.println("Is UserTextBox Present (via POM)?: " + userTextBoxPresent);
        testLogger.info("Is UserTextBox Present (via POM)?: " + userTextBoxPresent);

        hrmLoginPage.login("Admin", "admin123");
        Thread.sleep(3000);

        System.out.println("*** Title is ****: " + driver.getTitle());
        testLogger.pass(driver.getTitle());
        Assert.fail("Failed by Rahil");
    }

}
