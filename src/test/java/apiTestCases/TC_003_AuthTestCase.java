package apiTestCases;
import apiTesting.Authentication;
import apiTesting.EndPoints;
import apiTesting.PostData;
import apiTesting.Routes;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC_003_AuthTestCase {
   @Test
    public void testAuthentication()
   {
       Authentication.APIKeyAuthentication();
       Authentication.basicAuthentication();

   }

}
