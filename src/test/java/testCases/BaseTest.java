package testCases;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HRMLoginPage;
import utilities.*;


import java.io.IOException;
import java.lang.reflect.Method;

import java.util.Properties;

public class BaseTest {

    protected WebDriver driver;
    protected HRMLoginPage hrmLoginPage;
    protected SeleniumUtils seleniumUtils;
    public static Properties testDataProp;
    public static ConfigReader configReader = new ConfigReader();

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws IOException {
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();
        DriverFactory.launchURL();

        hrmLoginPage = new HRMLoginPage(driver);
        seleniumUtils = new SeleniumUtils(driver);

        testDataProp=configReader.loadConfigProperties(Constants.TEST_DATA_PROPERTIES_FILE_PATH);

    }
    @BeforeMethod(alwaysRun = true)
    public void setUpTest(Method method) {
        // Create ExtentTest for this test method (ThreadLocal)
        ExtentManager.createTest("TestCase: "+method.getName());
    }
    @AfterMethod(alwaysRun = true)
    public void tearDownTest(ITestResult result) throws IOException {
        WebDriver driver = this.driver;
        String testName = result.getMethod().getMethodName();

        if (result.getStatus() == ITestResult.FAILURE) {
            ExtentManager.getTest().log(Status.FAIL, "Test Failed: " + result.getThrowable());

            String screenshotPath = SeleniumUtils.takeScreenshot(driver);
            ExtentManager.getTest().addScreenCaptureFromPath(screenshotPath);

        } else if (result.getStatus() == ITestResult.SUCCESS) {
            ExtentManager.getTest().log(Status.PASS, "Test Passed");
        } else if (result.getStatus() == ITestResult.SKIP) {
            ExtentManager.getTest().log(Status.SKIP, "Test Skipped: " + result.getThrowable());
        }
        // Remove thread’s test instance after completion
        ExtentManager.unload();
    }
    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        DriverFactory.quitDriver();
    }
    @AfterSuite(alwaysRun = true)
    public void tearDownSuite() {
        ExtentManager.getExtentReports().flush();
        System.out.println("✅ Extent Report generated successfully!");
    }

}
