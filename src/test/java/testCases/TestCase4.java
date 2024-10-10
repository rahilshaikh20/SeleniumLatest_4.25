package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import utilities.Base;
import utilities.ExtentReportSetUp;

public class TestCase4 extends ExtentReportSetUp
{
    public WebDriver driver;
    Base base =new Base();

    @Test
    public void testCase4()
    {
        test=extent.createTest("TC_0004");
        test.info("**** This is a 4th TC ****");
        test.info("4th TC started");
        driver= base.loadDriver();
        base.loadURL();
        System.out.println(driver.getTitle());

        test.info("Title is: "+driver.getTitle());
        Assert.fail("Failed by the user");

    }
    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}