import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteMethod {
    @Test
    public void Deleteuser() {

        Response response = given()
                .header("content-type", "application/json")
                .delete("https://reqres.in/api/users?page=2");
        System.out.println("******" + response.asString());
        Assert.assertEquals(response.statusCode(), 204, "Expected  response code is 204 but found " + response.statusCode());

    }
}
