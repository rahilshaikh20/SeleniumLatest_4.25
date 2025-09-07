package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class TestCase2 {


    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\shaikh_ra\\Downloads\\EdgeDriver\\msedgedriver.exe");
        WebDriverManager.edgedriver().setup();
        // Create EdgeOptions and set headless mode
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--headless"); // Enable headless mode
        options.addArguments("--disable-gpu"); // Optional: Disable GPU acceleration
        options.addArguments("--no-sandbox"); // Optional: Disable sandboxing
        options.addArguments("--disable-dev-shm-usage"); // Optional: Overcome limited resource problems in Docker
        options.setCapability("ms:headless", true); // Enable headless

        // Initialize the Edge WebDriver with the specified options
        WebDriver driver = new EdgeDriver(options);

        // Initialize the Edge WebDriver with the specified options
        driver = new EdgeDriver(options);
        driver.get("https://www.example.com");
        System.out.println("Title: " + driver.getTitle());

    }


}
