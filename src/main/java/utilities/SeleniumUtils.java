package utilities;

/*** Should contain Selenium reusable methods to prevent common exceptions ***/

import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static utilities.Constants.DEFAULT_WAIT;
import static utilities.DriverFactory.getDriver;

public class SeleniumUtils {
    public WebDriver driver;
    public SeleniumUtils(WebDriver driver) {
        this.driver = driver;
    }
    public static String takeScreenshot(WebDriver driver) throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotDir = Constants.SCREENSHOT_FOLDER;
        Files.createDirectories(Paths.get(screenshotDir));
        String screenshotPath = screenshotDir +  "_" + System.currentTimeMillis() + ".png";
        Files.copy(srcFile.toPath(), Paths.get(screenshotPath));
        return screenshotPath;
    }

    public boolean isElementPresent(By Locator) {
        try {
            driver.findElement(Locator);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void waitForElementVisible(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void click(WebElement element) {
        try {
            waitForElementToBeClickable(element).click();
            ExtentManager.getTest().log(Status.PASS, "Clicked element: " + element);
        } catch (Exception e) {
            ExtentManager.getTest().log(Status.FAIL, "Click failed: " + e.getMessage());
            throw e;
        }
    }

    public static void sendKeys(WebElement element, String text) {
        try {
            waitForVisibility(element).clear();
            element.sendKeys(text);
            ExtentManager.getTest().log(Status.PASS, "Entered text: " + text);
        } catch (Exception e) {
            ExtentManager.getTest().log(Status.FAIL, "SendKeys failed: " + e.getMessage());
            throw e;
        }
    }

    public static WebElement waitForVisibility(WebElement element) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_WAIT))
                .until(ExpectedConditions.visibilityOf(element));
    }
    public static WebElement waitForElementToBeClickable(WebElement element) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_WAIT))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public static String getTitle() {
        try {
            String title = getDriver().getTitle();
            ExtentManager.getTest().log(Status.INFO, "Page Title captured is: " + title);
            return title;
        } catch (Exception e) {
            ExtentManager.getTest().log(Status.WARNING, "Unable to fetch title: " + e.getMessage());
            return null;
        }
    }

}
