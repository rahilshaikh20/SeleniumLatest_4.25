package testCases;

import org.testng.annotations.Test;
import utilities.ExtentReportSetUp;

import java.io.IOException;

public class TestCase6 extends ExtentReportSetUp {
    @Test
    public void TC6() throws InterruptedException, IOException {
        test = extent.createTest("TC_0006");
        test.info("Verify user login using Page Factory");
        System.out.println("****TC 6 executed !!!!!!!!");


    }

}
