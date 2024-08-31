package Test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PutPatchAndDelete {

    @Test
    public void PutReq() {
        JSONObject request = new JSONObject();
        //System.out.println(request);
        request.put("name", "Mona");
        request.put("job", "Engineer");
        baseURI = "https://reqres.in/api";
        given().
                body(request.toJSONString()).
                when().
                put("/users/2").  //put and patch are the same, except for that we put patch instead of put here
                then().
                statusCode(200).log().all();

    }
    @Test
    public void DeleteReq() {
        baseURI = "https://reqres.in/api";

                when().
                delete("/users/2").
                then().
                statusCode(204).log().all();

    }

}
