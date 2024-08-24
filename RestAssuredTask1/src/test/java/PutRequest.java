import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PutRequest {

    @Test
    public void PutReq() {
        JSONObject request = new JSONObject();
        //System.out.println(request);
        request.put("id","1");
        request.put("name", "popsy");

        baseURI = "https://petstore.swagger.io/v2";
        given().
                contentType(ContentType.JSON).
                body(request.toJSONString()).
                when().
                put("/pet").  //put and patch are the same, except for that we put patch instead of put here
                then().
                statusCode(200).log().all();

    }
}
