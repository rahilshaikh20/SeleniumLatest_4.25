package testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import utilities.DriverFactory;
import utilities.ExtentReportSetUp;

public class TestCase10 extends ExtentReportSetUp {

    DriverFactory driverFactory =new DriverFactory();
    @Test
    public void TC_10_1()
    {
        test = extent.createTest("TC_0010.1");
        test.info("*** TC_010.1 started !! ****");
        System.out.println(" *****  TC PASSED !!!!");test.pass("TC Passed");

    }
    @Test
    public void TC_10_2()
    {
        test = extent.createTest("TC_0010.2");
        test.info("*** TC_010.2 started !! ****");
        System.out.println(" *****  TC PASSED !!!!");test.pass("TC Passed");

    }
    @Test
    public void TC_10_3()
    {
        test = extent.createTest("TC_0010.3");
        test.info("*** TC_010.3 started !! ****");
        System.out.println(" *****  TC PASSED !!!!");test.pass("TC Passed");

    }
    @AfterClass
    public void tearDownTC10()
    {
        driverFactory.tearDown();
    }
}
