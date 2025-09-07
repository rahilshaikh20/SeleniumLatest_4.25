package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.HRMLoginPage;
import utilities.Base;
import utilities.DriverFactory;
import utilities.ExtentReportSetUp;

import java.io.IOException;
import java.util.Map;

public class TestCase1 extends ExtentReportSetUp {
    public WebDriver driver;
    DriverFactory driverFactory = new DriverFactory();
    @Test
    public void TC1() throws InterruptedException, IOException {
        test = extent.createTest("TC_0001");
        test.info("Verify user login");

        driver=driverFactory.loadBrowserDriver();
        driverFactory.launchURL();

        HRMLoginPage hrmLoginPage = new HRMLoginPage(driver);
        hrmLoginPage.login("Admin", "admin123");

        Thread.sleep(5000);
        test.pass(driver.getTitle());
    }
    @AfterClass
    public void driverQuit()
    {
        driver.quit();
    }


}
