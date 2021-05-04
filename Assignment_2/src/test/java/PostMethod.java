import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostMethod {
    @Test
    public void createUser() {
        RestAssured.baseURI = "https://reqres.in/";
        String reqBody = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        Response postResponse = given().header("content-type", "application/json")
                .body(reqBody).post("/api/users");
        System.out.println(postResponse.statusCode());
        System.out.println(postResponse.getBody().asString());
        Assert.assertEquals(postResponse.getStatusCode(), 201, "Expected 201" + postResponse.getStatusCode());
    }
    @Test
    public void LoginUser() {
        RestAssured.baseURI = "https://reqres.in/";
        String reqBody = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"cityslicka\"\n" +
                "}";
        Response postResponse = given().header("content-type", "application/json")
                .body(reqBody).post("/api/login");
        System.out.println(postResponse.statusCode());
        System.out.println(postResponse.getBody().asString());
        Assert.assertEquals(postResponse.getStatusCode(), 200, "Expected 200" + postResponse.getStatusCode());
    }
    @Test
    public void RegisterUser() {
        RestAssured.baseURI = "https://reqres.in/";
        String reqBody = "{\n" +
                "    \"email\": \"sydney@fife\"\n" +
                "}";
        Response postResponse = given().header("content-type", "application/json")
                .body(reqBody).post("/api/register");
        System.out.println(postResponse.statusCode());
        System.out.println(postResponse.getBody().asString());
        Assert.assertEquals(postResponse.getStatusCode(), 400, "Expected 400" + postResponse.getStatusCode());
    }
}

