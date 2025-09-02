package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class Base {
    public WebDriver driver;
    Properties prop = new Properties();
    public FileInputStream fis;
    //String URL = "https://www.manutd.com/"; // Website name to be launched
    //String browserName = "Chrome"; // Enter the Browser name

    public void loadURL() throws IOException // getting URL from string(Browser factory)
    {
        Base base =new Base();
        prop=base.loadProperties();
        String url =prop.getProperty("URL");
        driver.get(url);
    }
    public WebDriver loadDriver() throws IOException {

        Base base =new Base();
        prop=base.loadProperties();
        String browserName =prop.getProperty("BrowserName");

        if (browserName.equals("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else if (browserName.equalsIgnoreCase("Chrome")) {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);

        } else if (browserName.equalsIgnoreCase("IE")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        
        return driver;
    }
    public static String captureScreenshot(WebDriver driver) throws IOException
    {
        String pattern = "yyyy-MM-dd_HHmmss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        String imageWithPath=System.getProperty("user.dir")+"\\Screenshots"+"\\image_"+date+".PNG";

        FileHandler.createDir(new File(System.getProperty("user.dir")+"\\Screenshots"));
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(imageWithPath));

        return imageWithPath;

    }
    public Properties loadProperties() throws IOException {
        // prop = new Properties();
        fis = new FileInputStream(System.getProperty("user.dir") + "\\Base.properties");
        prop.load(fis);
        return prop;
    }

}
