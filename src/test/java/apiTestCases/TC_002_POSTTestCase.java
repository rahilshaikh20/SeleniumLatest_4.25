package apiTestCases;
import apiTesting.EndPoints;
import apiTesting.PostData;
import apiTesting.Routes;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC_002_POSTTestCase {

    PostData postData;
    Response resp;

    @BeforeTest
    public PostData setupPostData()
   {
       postData = new PostData();

       postData.setName("Akshay Kumar");
       postData.setSalary(Routes.SALARY); //Getting value from constant
       postData.setAge("59");
       return postData;
   }

   @Test
    public void testPOSTRequest()
   {
       resp =EndPoints.methodPOST(postData);
       resp.prettyPrint();
       System.out.println("Status code is: "+resp.statusCode());

   }

   @AfterTest
    public void getResponseJSONdata()
   {    //Get specific data from response by traversing the JSON path
       JsonPath extractor = resp.jsonPath();

       String name=extractor.get("data.name");
       int ID= extractor.get("data.id");

       System.out.println("Name retrived from Response: "+name);
       System.out.println("ID retrived from Response: "+ ID);
   }
}
