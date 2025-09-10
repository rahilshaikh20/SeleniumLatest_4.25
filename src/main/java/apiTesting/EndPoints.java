package apiTesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

//Endpoints to contain all API methods
public class EndPoints {
    public static Response methodGET()
    {
        // Specify the base URL to the REST-ful web service
        RestAssured.baseURI = Routes.URI;
        // Get the RequestSpecification of the request that you want to send to the server. The server is specified by the BaseURI that we have
        RequestSpecification httpRequest = given();
        // Make a request to the server by specifying the method Type and the method URL.
        // This will return the Response from the server. Store the response in a variable.
        Response response = httpRequest.request(Method.GET, Routes.GET_END_POINT);

        System.out.println("Status code is: "+response.getStatusCode());
        System.out.println("Pretty Print: "+response.prettyPrint());

        return response;

    }
    public static Response methodPOST(PostData payload)
    {
        Response response = given().
                contentType(ContentType.JSON)
                .accept(ContentType.JSON).body(payload)
                .when()
                .post(Routes.URI+Routes.POST_END_POINT);
                //.then().statusCode(200);
        return response;

    }


}
