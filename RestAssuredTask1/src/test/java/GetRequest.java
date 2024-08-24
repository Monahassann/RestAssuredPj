import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.baseURI;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest {

    @Test
    public void GetReq() {
        baseURI = "https://petstore.swagger.io/v2";
        String status = "pending" ;
        given().
                queryParam("status", status).
                when().
                get("/pet/findByStatus").
                then().
                assertThat().
                statusCode(200);


    }
}
