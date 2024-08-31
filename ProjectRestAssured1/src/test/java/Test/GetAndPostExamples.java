package Test;

import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetAndPostExamples {

    @Test
    public void testGet() {
        given().
                get("https://reqres.in/api/users?page=2").
                then().
                statusCode(200).
                body("data[1].first_name",equalTo("Lindsay")).
                body("data[5].email", equalTo("rachel.howell@reqres.in"));

    }

   @Test
   public void PostReq() {
       Map<String, Object> map = new HashMap<String, Object>();
       map.put("name", "Mona");
       map.put("job", "Engineer");
       System.out.println(map);

       JSONObject request = new JSONObject(map);
       //System.out.println(request);
       request.put("name", "Mona");
       request.put("job", "Engineer");
       baseURI = "https://reqres.in/api";
       given().
               body(request.toJSONString()).
               when().
               post("/users").
               then().
               statusCode(201).log().all();



   }
}
