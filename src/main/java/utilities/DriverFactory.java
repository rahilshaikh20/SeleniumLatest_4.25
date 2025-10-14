package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

/**
 * Thread-safe WebDriver factory using ThreadLocal
 */
public class DriverFactory {

    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    private static Properties prop;
    private static ConfigReader configReader = new ConfigReader();

    /**
     * Initialize browser driver for the current thread
     */
    public synchronized static void initDriver() throws IOException {
        if (tlDriver.get() == null) {
            prop = configReader.loadConfigProperties(Constants.CONFIG_PROPERTIES_FILE_PATH);
            String browserName = prop.getProperty("BrowserName", "Chrome");

            WebDriver driver = null;

            switch (browserName.toLowerCase()) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;

                case "chrome":
                default:
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    if (Constants.CHROME_RUN_HEADLESS_MODE.equalsIgnoreCase("YES")) {
                        options.addArguments("--headless=new");
                    }
                    driver = new ChromeDriver(options);
                    break;
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.DEFAULT_WAIT));
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();

            tlDriver.set(driver);
        }
    }

    /**
     * Get driver instance for the current thread
     */
    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }

    /**
     * Launch URL from config
     */
    public static synchronized void launchURL() throws IOException {
        String url = configReader.loadConfigProperties(Constants.CONFIG_PROPERTIES_FILE_PATH).getProperty("URL");
        getDriver().get(url);
    }

    /**
     * Quit driver for the current thread
     */
    public static synchronized void quitDriver() {
        if (tlDriver.get() != null) {
            tlDriver.get().quit();
            tlDriver.remove();
            System.out.println("Driver closed for thread: " + Thread.currentThread().getId());
        }
    }
}
