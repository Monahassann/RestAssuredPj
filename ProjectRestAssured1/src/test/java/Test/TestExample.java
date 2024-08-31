package Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestExample {


    @Test
    public void test1() {
        Response response = get("https://reqres.in/api/users?page=2");
        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getBody().asString());
        System.out.println(response.getCookies());


        Assert.assertEquals(response.getStatusCode(), 200);
    }
    @Test
    public void test2() {
        //String baseUrl = ("https://reqres.in/api");
        given().
                get("https://reqres.in/api/users?page=2").
                then().
                statusCode(200).
               body("data[1].id",equalTo(8));
    }
}
