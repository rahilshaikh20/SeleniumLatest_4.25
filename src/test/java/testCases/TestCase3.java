package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import utilities.Constants;
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
        test.info("Verify Man united official Page");
        driver = driverFactory.loadBrowserDriver();
        driver.get(Constants.BASE_URL);
        test.pass(driver.getTitle());

        //Assert.fail();
    }
    @AfterClass
    public void driverQuit() {
        driverFactory.tearDown();
    }
}
