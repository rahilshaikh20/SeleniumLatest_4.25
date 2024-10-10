package testCases;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.Map;

public class TestCase1 {

    WebDriver driver = null;

    @Test
    public void TC1() throws InterruptedException {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\shaikh_ra\\Downloads\\EdgeDriver\\msedgedriver.exe");

        EdgeOptions options = new EdgeOptions();
        options.addArguments("headless"); // Enable headless mode
        options.setCapability("ms:headless", true); // Enable headless

        // Initialize the Edge WebDriver with the specified options
        driver = new EdgeDriver(options);
        driver.get("https://www.fieldglass.net/");
        System.out.println("Title: " + driver.getTitle());

        Thread.sleep(2000);

    }
    @AfterClass
    public void driverQuit()
    {
        driver.quit();
    }


}
