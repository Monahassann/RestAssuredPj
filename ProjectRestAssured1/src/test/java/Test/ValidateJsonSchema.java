package Test;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;


public class ValidateJsonSchema {

    @Test
    public void testGet() {
        given().
                get("https://reqres.in/api/users?page=2").
                then().
                assertThat().body(matchesJsonSchemaInClasspath("Schema.json")).
                statusCode(200);

    }
}

