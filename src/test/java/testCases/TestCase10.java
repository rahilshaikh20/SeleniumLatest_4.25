package testCases;

import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HRMLoginPage;
import utilities.ExtentReportSetUp;

public class TestCase10 extends BaseTest {

    @Test
    public void TC10()  {
        ExtentTest testLogger = getExtent().createTest("TestCase_010");
        setTest(testLogger);
        testLogger.info("Verify data from config ");
        System.out.println("*** TC started ***");

     /*   String name = testDataProp.getProperty("name");
        String age = testDataProp.getProperty("age");

        testLogger.info("User name: "+name+" | Age: "+age);
        System.out.println("User name: "+name+" | Age: "+age);*/

    }
}
