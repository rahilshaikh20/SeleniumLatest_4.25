package utilities;

/*** Should contain Selenium reusable methods to prevent common exceptions ***/

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

}
