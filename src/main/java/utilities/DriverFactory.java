package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class DriverFactory {

    WebDriver driver;

    public FileInputStream fis;
    public Properties prop = new Properties();

    public WebDriver loadBrowserDriver() throws IOException {

        prop=DriverFactory.this.loadProperties();
        String browserName=  prop.getProperty("BrowserName");

        //String browserName=  "Chrome";


        if (browserName.equals("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else if (browserName.equalsIgnoreCase("Chrome")) {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("IE")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        return driver;
    }

    public void launchURL() throws IOException // getting URL from string(Browser factory)
    {
        prop=DriverFactory.this.loadProperties();
        String url =prop.getProperty("URL");
        driver.get(url);

        //driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    public Properties loadProperties() throws IOException {
        // prop = new Properties();
        fis = new FileInputStream(System.getProperty("user.dir") + "//Base.properties"); // For Mac use forward /
        System.out.println("From Load Properties method: "+fis);
        prop.load(fis);
        return prop;
    }
}
