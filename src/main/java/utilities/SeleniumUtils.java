package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeleniumUtils {
    public WebDriver driver;
    public SeleniumUtils(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isElementPresent(By Locator)
    {
        try {
            driver.findElement(Locator);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
