package utilities;

/*** Should contain Selenium reusable methods to prevent common exceptions ***/

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class SeleniumUtils {
    public WebDriver driver;

    public SeleniumUtils(WebDriver driver) {
        this.driver = driver;
    }

    public static String captureScreenshot(WebDriver driver) throws IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.DATE_PATTERN);
        String date = simpleDateFormat.format(new Date());
        String imageWithPath = Constants.SCREENSHOT_FOLDER + "//image_" + date + ".PNG";
        FileHandler.createDir(new File(Constants.SCREENSHOT_FOLDER));
        //**Note: Use // for mac and \\ for Windows
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(imageWithPath));

        return imageWithPath;

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
