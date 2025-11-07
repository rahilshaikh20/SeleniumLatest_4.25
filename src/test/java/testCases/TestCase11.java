package testCases;
// A cleaner version of writing scripts using separate Base Test. Verify user login via BaseTest

import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HRMLoginPage;
import utilities.ExtentManager;
import utilities.SeleniumUtils;

public class TestCase11 extends BaseTest {

    @Test
    public void TC11() throws InterruptedException {
        ExtentTest test = ExtentManager.getTest();
        test.info("Verify user login via Base Test 11");

        boolean userTextBoxPresent = seleniumUtils.isElementPresent(HRMLoginPage.userNameTextbox);
        System.out.println("Is UserTextBox Present (via POM)?: " + userTextBoxPresent);
        test.pass("Is UserTextBox Present (via POM)?: " + userTextBoxPresent);

        hrmLoginPage.login("Admin", "admin123");
        Thread.sleep(3000);

        test.info("Password is hidden ##");
        SeleniumUtils.getTitle(); //Using utilities method with Extent logger inbuilt
        System.out.println("*** Title is ****: " + driver.getTitle());
        Assert.fail(" !! Failed intentionally !!!!!");
    }

}
