package testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import utilities.DriverFactory;
import utilities.ExtentReportSetUp;

public class TestCase10 extends ExtentReportSetUp {

    DriverFactory driverFactory =new DriverFactory();
    @Test
    public void TC_10()
    {
        test = extent.createTest("TC_0010");
        test.info("*** TC_010 started !! ****");
        System.out.println(" *****  TC PASSED !!!!");test.pass("TC Passed");

    }
    @AfterClass
    public void tearDownTC10()
    {
        driverFactory.tearDown();
    }
}
