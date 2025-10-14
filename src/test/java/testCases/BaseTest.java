package testCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HRMLoginPage;
import utilities.ConfigReader;
import utilities.Constants;
import utilities.DriverFactory;
import utilities.SeleniumUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

public class BaseTest {

    protected WebDriver driver;
    protected HRMLoginPage hrmLoginPage;
    protected SeleniumUtils seleniumUtils;
    public static Properties testDataProp;
    public static ConfigReader configReader = new ConfigReader();

    public static ExtentSparkReporter htmlReporter;
    public static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    public static ExtentTest getTest(){return test.get();}
    public static void setTest(ExtentTest extentTest){test.set(extentTest);}
    public static ExtentReports getExtent(){return extent;};

    @BeforeSuite
    public void setUp() throws MalformedURLException {
        htmlReporter = new ExtentSparkReporter(Constants.EXTENT_REPORTS_PATH);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        htmlReporter.config().setDocumentTitle(Constants.EXTENT_REPORTS_TITLE);
        htmlReporter.config().setReportName(Constants.EXTENT_REPORTS_NAME);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setTimelineEnabled(true);

        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
    }

    @BeforeClass
    public void setup() throws IOException {
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();
        DriverFactory.launchURL();

        hrmLoginPage = new HRMLoginPage(driver);
        seleniumUtils = new SeleniumUtils(driver);

        testDataProp=configReader.loadConfigProperties(Constants.TEST_DATA_PROPERTIES_FILE_PATH);

    }

    @AfterMethod(alwaysRun = true)
    public void getResult(ITestResult result) throws IOException {
        ExtentTest testLogger =getTest();

        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
            //Get the driver instance from the running Test Class*/
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (result.getStatus() == ITestResult.FAILURE) {

            if (driver != null) { //take screenshot if driver instance is not null
                String screenshot = SeleniumUtils.captureScreenshot(driver);
                System.out.println(screenshot);
                testLogger.addScreenCaptureFromPath(screenshot);
            }
            testLogger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:", ExtentColor.RED));
            testLogger.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            testLogger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
        } else {
            testLogger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.ORANGE));
            testLogger.skip(result.getThrowable());
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    @AfterSuite(alwaysRun = true)
    public void flushReport() {
        extent.flush();
        System.out.println("Extent report generated successfully!");
    }

}
