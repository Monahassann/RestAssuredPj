import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PostRequest {

    @Test
    public void PostReq() throws IOException {
        int petId = 2;
        File file = new File("C:\\Users\\migomaa\\Downloads\\Bussinessrule.PNG");
        if (file.exists())
            System.out.println(" >>> file exists");

        baseURI = "https://petstore.swagger.io/v2";
        given().
                multiPart("file", file).
                queryParam("petId", petId).
                when().
                post("/pet/" + petId + "/uploadImage").
                then().
                statusCode(200).log().all();



    }
}
