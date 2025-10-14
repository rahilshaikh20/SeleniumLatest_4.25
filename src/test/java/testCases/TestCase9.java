package testCases;

import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ExtentReportSetUp;

import static utilities.ExtentReportSetUp.extent;


public class TestCase9 extends BaseTest {

    @Test
    public void TC_9_1()
    {
        //ExtentTest test = ExtentReportSetUp.getTest();
        ExtentTest test = extent.createTest("TestCase_009","Description of TC_9");

        test.info("*** TC_009.1 started !! ****");
        test.pass("*** *****  TC 9.1 PASSED !!!!");
        System.out.println(" *****  TC 9.1 PASSED !!!!");
        //Assert.fil
    }

}
