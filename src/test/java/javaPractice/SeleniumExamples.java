package javaPractice;
import io.github.bonigarcia.wdm.config.WebDriverManagerException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Set;

public class SeleniumExamples  {
    public static void main(String[] args) throws WebDriverException,
            WebDriverManagerException,ElementNotInteractableException {
        // ✅ Setup WebDriver (make sure chromedriver is in PATH)
        //WebDriver driver = new ChromeDriver();
        ChromeOptions options =new ChromeOptions();
        options.merge(new ImmutableCapabilities());
        options.setCapability("browser", "chrome");

        System.out.println("Browser is: "+options.getBrowserName());
        System.out.println("Platform is: "+options.getPlatformName());
        System.out.println("Cap is: "+options.getCapabilityNames());
        System.out.println("Version is: "+options.getBrowserVersion());

        WebDriverWait wait;



      /*  driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.switchTo().frame(0);

        // ======================================
        // 1. Handling Alerts
        // ======================================
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // Click button to trigger alert
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        // Switch to alert and accept
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert Text: " + alert.getText());
        alert.accept();   // click OK

        // Trigger confirm alert
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        alert = driver.switchTo().alert();
        alert.dismiss();  // click Cancel

        // Trigger prompt alert
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        alert = driver.switchTo().alert();
        alert.sendKeys("Hello from Selenium!");
        alert.accept();

        // ======================================
        // 2. Handling iFrames
        // ======================================
        driver.get("https://the-internet.herokuapp.com/iframe");

        // Switch into iframe
        driver.switchTo().frame("mce_0_ifr");
        WebElement editor = driver.findElement(By.id("tinymce"));
        editor.clear();
        editor.sendKeys("Typing inside an iFrame!");

        // Switch back to main content
        driver.switchTo().defaultContent();
        Assert.assertTrue(true);

        // ======================================
        // 3. Handling Multiple Windows
        // ======================================
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.findElement(By.linkText("Click Here")).click();

        // Get window handles
        String parentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        for (String win : allWindows) {
            if (!win.equals(parentWindow)) {
                driver.switchTo().window(win);
                System.out.println("New Window Title: " + driver.getTitle());
                driver.close(); // close new window
            }
        }

        // Switch back to parent
        driver.switchTo().window(parentWindow);

        // Cleanup
        driver.quit();*/
    }
}
