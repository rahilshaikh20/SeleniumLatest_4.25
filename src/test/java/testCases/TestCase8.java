package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ExtentReportSetUp;

public class TestCase8 extends ExtentReportSetUp {
    WebDriver driver;
      @Test
    public void TC8() {
        test = extent.createTest("TC_0008");
        test.info("Verify user login using Page Factory");
          System.out.println("****TC 8 executed !!!!!!!!");
          WebDriverManager.chromedriver().setup();
          driver = new ChromeDriver();
          driver.get("https://playwright.dev/docs/intro");
          driver.manage().window().maximize();
          System.out.println("Title is: "+driver.getTitle());


    }

}
