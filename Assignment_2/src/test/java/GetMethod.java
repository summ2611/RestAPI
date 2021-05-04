import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;

public class GetMethod {

    @Test
    public void getUsers()
    {
        Response response = given()
                .header("content-type","application/json")
                .get("https://reqres.in/api/users");
        System.out.println(response.asString());
        Assert.assertEquals(response.statusCode(),200,"Expected response code was 200 but found"+response.statusCode());

    }

    @Test
    public void getSigleUserNotFound()
    {
        RestAssured.baseURI = "https://reqres.in/";
        Response response = given()
                .header("content-type","application/json")
                .get("/api/users/23");
        System.out.println(response.asString());
        Assert.assertEquals(response.statusCode(),404,"Expected response code was 200 but found"+response.statusCode());

    }

}