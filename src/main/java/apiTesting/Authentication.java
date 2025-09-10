package apiTesting;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class Authentication {

    public static void APIKeyAuthentication()
    {
        Response response =
                given()
                .headers("Authorization", "x-api-key reqres-free-v1") //Setting API key in input header
                //.pathParam("myPath", "/api/users")

                .when()
                .get("https://reqres.in/api/users/3")

                .then()
                .statusCode(200)
                .extract().response();

        response.prettyPrint();
        System.out.println("Status Code is: "+response.statusCode());
        System.out.println(response.getHeaders().get("Vary")); //Getting value from output Header
    }

    public static void basicAuthentication() {
                given().auth().basic("postman", "password")
                .when().get("https://postman-echo.com/basic-auth")
                .then().statusCode(200).log().all();
    }
}


