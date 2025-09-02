package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import utilities.Base;
import utilities.ExtentReportSetUp;

import java.io.IOException;

public class TestCase3 extends ExtentReportSetUp {

    public WebDriver driver;
    Base base =new Base();
    @Test
    public void TC3() throws IOException, InterruptedException {
        System.out.println("*********TC 3 Executed !! ******");


        test = extent.createTest("TC_0003");
        test.info("Verify Manu Page");
        driver = base.loadDriver();
        driver.get("https://www.manutd.com/");
        driver.manage().window().maximize();

        Assert.fail();
    }
    @AfterClass
    public void driverQuit()
    {
        driver.quit();
    }
}
