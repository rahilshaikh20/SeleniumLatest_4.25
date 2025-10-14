package apiTestCases;
import apiTesting.Authentication;
import org.testng.annotations.Test;

public class TC_003_AuthTestCase {
   @Test
    public void testAuthentication()
   {
       Authentication.APIKeyAuthentication();
       Authentication.basicAuthentication();

   }

}
