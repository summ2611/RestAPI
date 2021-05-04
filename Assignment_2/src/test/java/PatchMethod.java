import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PatchMethod {
    @Test
    public void UpdateUser() {
        RestAssured.baseURI = "https://reqres.in/";
        String reqBody = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}";
        Response patchResponse = given().header("content-type", "application/json")
                .body(reqBody).patch("/api/users/2");
        System.out.println(patchResponse.statusCode());
        System.out.println(patchResponse.getBody().asString());
        Assert.assertEquals(patchResponse.getStatusCode(), 200, "Expected 200 " + patchResponse.getStatusCode());
    }
}
