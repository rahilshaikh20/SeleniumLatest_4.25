package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class ExtentReportSetUp {
    public static ExtentSparkReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;
    WebDriver driver;

    @BeforeSuite
    public void setUp() {
        htmlReporter = new ExtentSparkReporter(Constants.EXTENT_REPORTS_PATH);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        htmlReporter.config().setDocumentTitle(Constants.EXTENT_REPORTS_TITLE);
        htmlReporter.config().setReportName(Constants.EXTENT_REPORTS_NAME);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setTimelineEnabled(true);
    }

    @AfterMethod
    public void getResult(ITestResult result) throws NoSuchFieldException, IllegalAccessException, IOException, InterruptedException {
        if (result.getStatus() == ITestResult.FAILURE) {
            try {
                driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
                //Get the driver instance from the running Test Class*/
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (driver != null) { //take screenshot if driver instance is not null
                String screenshot = SeleniumUtils.captureScreenshot(driver);
                System.out.println(screenshot);
                test.addScreenCaptureFromPath(screenshot);
            }
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:", ExtentColor.RED));
            test.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
        } else {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
    }

    @AfterSuite
    public void ExtentTearDown() {
        extent.flush();
        System.out.println("Report Flushed ...!!!");
    }

}