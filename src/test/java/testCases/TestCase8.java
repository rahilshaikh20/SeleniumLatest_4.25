package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ExtentReportSetUp;

public class TestCase8 extends ExtentReportSetUp {
      @Test
    public void TC8() {
        test = extent.createTest("TC_0008");
        test.info("Verify user login using Page Factory");
          System.out.println("****TC 8 executed !!!!!!!!");
          //Assert.fail("Failed by Rahil !!!!");

    }

}
