package testCases;

import org.testng.annotations.Test;
import utilities.ExtentReportSetUp;

public class TestCase9 extends ExtentReportSetUp {

    @Test
    public void TC_9_1()
    {
        test = extent.createTest("TC_009.1");
        test.info("*** TC_009.1 started !! ****");
        System.out.println(" *****  TC 9.1 PASSED !!!!");
    }
    @Test
    public void TC_9_2()
    {
        test = extent.createTest("TC_009.2");
        test.info("*** TC_009.2 started !! ****");
        System.out.println(" *****  TC 9.2 PASSED !!!!");
    }
    @Test
    public void TC_9_3()
    {
        test = extent.createTest("TC_009.3");
        test.info("*** TC_009.3 started !! ****");
        System.out.println(" *****  TC 9.3 PASSED !!!!");
    }
    @Test
    public void TC_9_4()
    {
        test = extent.createTest("TC_009.4");
        test.info("*** TC_009.4 started !! ****");
        System.out.println(" *****  TC 9.4 PASSED !!!!");
    }
    @Test
    public void TC_9_5()
    {
        System.out.println(" *****  TC 9.5 PASSED !!!!");
    }
}
