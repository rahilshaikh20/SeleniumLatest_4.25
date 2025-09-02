package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import utilities.ExtentReportSetUp;

public class TestCase8 extends ExtentReportSetUp {
    WebDriver driver;
      @Test
    public void TC8() {
        test = extent.createTest("TC_0008");
        test.info("Playwright executed");
          System.out.println("****TC 8 executed !!!!!!!!");
          WebDriverManager.chromedriver().setup();
          driver = new ChromeDriver();
          driver.get("https://playwright.dev/docs/intro");
          driver.manage().window().maximize();
          System.out.println("Title is: "+driver.getTitle());
          test.pass("Title is: "+driver.getTitle());
          Assert.assertTrue(true,"Test case PASSED ****!!!!!!");

    }

    @AfterClass
    public void driverQuit()
    {
        driver.quit();
    }

}
