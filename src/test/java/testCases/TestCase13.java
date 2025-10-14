package testCases;
// A cleaner version of writing scripts using separate Base Test. Verify user login via BaseTest

import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HRMLoginPage;
import utilities.ExtentReportSetUp;

public class TestCase13 extends BaseTest {

  @Test
    public void TC13() {
      ExtentTest test = ExtentReportSetUp.getTest();
      test.info("Verify user login via Base Test 13");

      boolean userTextBoxPresent = seleniumUtils.isElementPresent(HRMLoginPage.userNameTextbox);
      System.out.println("Is UserTextBox Present (via POM)?: " + userTextBoxPresent);
      test.info("Is UserTextBox Present (via POM)?: " + userTextBoxPresent);
      test.info("New info for Test-13");

      hrmLoginPage.login("Admin", "admin123");
      System.out.println("*** Title is ****: " + driver.getTitle());
      test.pass(driver.getTitle());

    }

}
