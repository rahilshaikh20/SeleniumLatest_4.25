package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import utilities.Base;
import utilities.DriverFactory;
import utilities.ExtentReportSetUp;

import java.io.IOException;

public class TestCase3 extends ExtentReportSetUp {

    public WebDriver driver;
    DriverFactory driverFactory = new DriverFactory();
    @Test
    public void TC3() throws IOException, InterruptedException {
        System.out.println("*********TC 3 Executed !! ******");


        test = extent.createTest("TC_0003");
        test.info("Verify Manu Page");
        driver=driverFactory.loadBrowserDriver();
        driver.get("https://www.manutd.com/");
        test.pass(driver.getTitle());

        Assert.fail();
    }
    @AfterClass
    public void driverQuit()
    {
        driver.quit();
    }
}
