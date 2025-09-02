package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.HRMLoginPage;
import pages.HRMLoginPageFactory;
import utilities.Base;
import utilities.ExtentReportSetUp;

import java.io.IOException;

public class TestCase5 extends ExtentReportSetUp {
    public WebDriver driver;
    Base base = new Base();
    @Test
    public void TC1() throws InterruptedException, IOException {
        test = extent.createTest("TC_0005");
        test.info("Verify user login using Page Factory");
        driver=base.loadDriver();
        base.loadURL();
        HRMLoginPageFactory hrmLoginPage = new HRMLoginPageFactory(driver);
        hrmLoginPage.loginPageFactory("Admin", "admin123");

        //Assert.assertTrue(driver.getPageSource().contains("My Actions"));
        System.out.println(driver.getTitle());
        Thread.sleep(3000);


    }
    @AfterClass
    public void driverQuit()
    {
        driver.quit();
    }


}
