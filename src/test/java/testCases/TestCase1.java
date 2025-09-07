package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.HRMLoginPage;
import utilities.DriverFactory;
import utilities.ExtentReportSetUp;
import utilities.SeleniumUtils;

import java.io.IOException;

public class TestCase1 extends ExtentReportSetUp {
    public WebDriver driver;
    DriverFactory driverFactory = new DriverFactory();

    @Test
    public void TC1() throws InterruptedException, IOException {
        test = extent.createTest("TC_0001");
        test.info("Verify user login");

        driver = driverFactory.loadBrowserDriver();
        driverFactory.launchURL();

        SeleniumUtils seleniumUtils = new SeleniumUtils(driver);
        boolean userTextBoxPresent1 = seleniumUtils.isElementPresent(HRMLoginPage.userNameTextbox);
        System.out.println("Is UserTextBox Present (via POM)?: " + userTextBoxPresent1);

        HRMLoginPage hrmLoginPage = new HRMLoginPage(driver);
        hrmLoginPage.login("Admin", "admin123");

        System.out.println("***Title is ****: " + driver.getTitle());
        test.pass(driver.getTitle());
    }

    @AfterClass
    public void driverQuit() {
        driver.quit();
    }


}
