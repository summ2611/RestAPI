import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PutMethod {
    @Test
    public void Updateuser() {
        RestAssured.baseURI = "https://reqres.in/";
        String reqBody = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}";
        Response putResponse = given().header("content-type", "application/json")
                .body(reqBody).put("/api/users/2");
        System.out.println(putResponse.statusCode());
        System.out.println(putResponse.getBody().asString());
        Assert.assertEquals(putResponse.getStatusCode(), 200, "Expected 200 " + putResponse.getStatusCode());
    }
}
