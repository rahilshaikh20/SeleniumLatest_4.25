package testCases;

import org.testng.annotations.Test;
import utilities.ExtentReportSetUp;

import java.io.IOException;

public class TestCase7 extends ExtentReportSetUp {
      @Test
    public void TC7() {
        test = extent.createTest("TC_0007");
        test.info("Verify user login using Page Factory");
          System.out.println("****TC 7 executed !!!!!!!!");

    }

}
