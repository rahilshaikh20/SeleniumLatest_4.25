package appiumTestCases;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HRMLoginPage;
import utilities.DriverFactory;
import utilities.ExtentReportSetUp;
import utilities.SeleniumUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class TestCase1_Appium extends ExtentReportSetUp {

    private AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Path to your downloaded APK
        String appPath = System.getProperty("user.home") + "/Downloads/ApiDemos-debug.apk";

        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName("Android Emulator")  // Use `adb devices` to check name if needed
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setApp(appPath);

        driver = new AndroidDriver(new URL("http://localhost:4723"), options);
    }

    @Test
    public void testClickOnPreference() {
        // Click on "Preference"
        WebElement preference = driver.findElement(AppiumBy.accessibilityId("Preference"));
        preference.click();

        // Click on "3. Preference dependencies"
        WebElement dependencies = driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies"));
        dependencies.click();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
