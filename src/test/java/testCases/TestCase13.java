package testCases;
// A cleaner version of writing scripts using separate Base Test. Verify user login via BaseTest

import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HRMLoginPage;

public class TestCase13 extends BaseTest {

    @Test
    public void TC13() throws InterruptedException {
        ExtentTest testLogger = getExtent().createTest("TestCase_013");
        setTest(testLogger);

        testLogger.info("Verify user login via Base Test 13");

        boolean userTextBoxPresent = seleniumUtils.isElementPresent(HRMLoginPage.userNameTextbox);
        System.out.println("Is UserTextBox Present (via POM)?: " + userTextBoxPresent);
        testLogger.info("Is UserTextBox Present (via POM)?: " + userTextBoxPresent);

        hrmLoginPage.login("Admin", "admin123");
        Thread.sleep(3000);

        System.out.println("*** Title is ****: " + driver.getTitle());
        testLogger.pass(driver.getTitle());

    }

}
