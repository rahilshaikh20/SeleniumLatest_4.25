package testCases;

import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HRMLoginPage;
import utilities.ExtentReportSetUp;



public class TestCase10 extends BaseTest {

    @Test
    public void TC10()  {
        ExtentTest test = ExtentReportSetUp.getTest();
        test.info("Test for data.properties");

        String name = testDataProp.getProperty("name");
        String age = testDataProp.getProperty("age");

        test.pass("User name: "+name+" | Age: "+age);
        System.out.println("User name: "+name+" | Age: "+age);

        Assert.fail();

    }
}
