package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HRMLoginPage {
    public static By userNameTextbox = By.name("username");
    public static By passwordTextbox = By.name("password");
    public static By submit = By.xpath("//button[@type='submit']");
    public WebDriver driver;

    public HRMLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String userName, String password) {
        driver.findElement(userNameTextbox).sendKeys(userName);
        driver.findElement(passwordTextbox).sendKeys(password);
        driver.findElement(submit).click();

    }
}
