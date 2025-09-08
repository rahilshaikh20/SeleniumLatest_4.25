package apiTestCases;
import apiTesting.EndPoints;
import apiTesting.PostData;
import apiTesting.Routes;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC_002_POSTTestCase {

   PostData postData;

   @BeforeTest
    public PostData setupPostData()
   {
       postData = new PostData();

       postData.setName("Ashraf Shaikh");
       postData.setSalary(Routes.SALARY); //Getting value from constant
       postData.setAge("64");
       return postData;
   }

   @Test
    public void testPOSTRequest()
   {
       Response resp =EndPoints.methodPOST(postData);
       resp.prettyPrint();
       System.out.println("Status is: "+resp.statusCode());

   }
}
