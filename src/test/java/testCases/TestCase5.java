package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.HRMLoginPageFactory;
import utilities.DriverFactory;
import utilities.ExtentReportSetUp;

import java.io.IOException;

public class TestCase5 extends ExtentReportSetUp {
    public WebDriver driver;
    DriverFactory driverFactory = new DriverFactory();

    @Test
    public void TC1() throws InterruptedException, IOException {
        test = extent.createTest("TC_0005");
        test.info("Verify user login using Page Factory");
        driver = driverFactory.loadBrowserDriver();
        driverFactory.launchURL();
        HRMLoginPageFactory hrmLoginPage = new HRMLoginPageFactory(driver);
        hrmLoginPage.loginPageFactory("Admin", "admin123");

        //Assert.assertTrue(driver.getPageSource().contains("My Actions"));
        System.out.println(driver.getTitle());
        test.pass(driver.getTitle());
        Thread.sleep(3000);


    }

    @AfterClass
    public void driverQuit() {
        driver.quit();
    }


}
