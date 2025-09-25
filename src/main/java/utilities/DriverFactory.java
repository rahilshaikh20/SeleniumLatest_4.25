package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

/****Refer Driver factory for a cleaner code instead of Base class***/
public class DriverFactory {

    public FileInputStream fis;
    public Properties prop = new Properties();
    WebDriver driver;
    ConfigReader configReader = new ConfigReader();



    public WebDriver loadBrowserDriver() throws IOException {
        //prop=DriverFactory.this.loadProperties();
        prop = configReader.loadConfigProperties();
        String browserName = prop.getProperty("BrowserName");

        if (browserName.equals("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else if (browserName.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();

            if (Constants.CHROME_RUN_HEADLESS_MODE.equalsIgnoreCase("YES")) {
                options.addArguments("--headless=new");
            }
            driver = new ChromeDriver(options);

        } else if (browserName.equalsIgnoreCase("IE")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.DEFAULT_WAIT));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        return driver;
    }

    public void launchURL() throws IOException // getting URL from string(Browser factory)
    {
        prop = configReader.loadConfigProperties();
        String url = prop.getProperty("URL");
        driver.get(url);
    }

    public void tearDown() {

        if (driver != null)
        {
            ExtentReportSetUp.test.info("Browser is closed");
            System.out.println("** Browser quit **");
            driver.quit();
        }
    }

}
