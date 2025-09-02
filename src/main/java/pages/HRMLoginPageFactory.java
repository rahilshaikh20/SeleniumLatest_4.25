package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HRMLoginPageFactory {
    public WebDriver driver;

    @FindBy(name="username")
    public WebElement userTextbox;
    @FindBy(name="password")
    public WebElement pwdTextbox;
    @FindBy(xpath="//button[@type='submit']")
    public WebElement submitButton;

    public HRMLoginPageFactory(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this); // initialize @FindBy fields
    }

    public void loginPageFactory(String userName, String password)
    {
        userTextbox.sendKeys(userName);
        pwdTextbox.sendKeys(password);
        submitButton.click();

    }
}
