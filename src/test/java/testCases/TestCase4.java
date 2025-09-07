package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import utilities.DriverFactory;
import utilities.ExtentReportSetUp;

import java.io.IOException;

public class TestCase4 extends ExtentReportSetUp {
    public WebDriver driver;
    DriverFactory driverFactory = new DriverFactory();

    @Test
    public void testCase4() throws IOException, InterruptedException {
        test = extent.createTest("TC_0004");
        test.info("**** This is a 4th TC ****");
        test.info("4th TC started");
        driver = driverFactory.loadBrowserDriver();
        driverFactory.launchURL();
        System.out.println(driver.getTitle());

        test.info("Title is: " + driver.getTitle());
        //Assert.fail("Failed by the user");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}