package apiTestCases;
import apiTesting.EndPoints;
import io.restassured.*;
import io.restassured.response.Response;
import org.testng.Assert;

public class TC_001_GETTestCase {

    public static void main(String[] args) {

        Response response=EndPoints.methodGET();
        Assert.assertTrue(response.statusCode()==200 ,"Incorrect Response code");
        response.prettyPrint();
    }
}
