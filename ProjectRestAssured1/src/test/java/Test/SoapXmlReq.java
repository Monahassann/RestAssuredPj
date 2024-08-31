package Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

 //http://www.dneonline.com/calculator.asmx?op=Add
public class SoapXmlReq {

    @Test
    public void validateSoapXml() throws IOException {


        File file = new File("C:\\Users\\migomaa\\Desktop\\add.xml");
        if (file.exists())
            System.out.println(" >>> file exists");

        FileInputStream fileInputStream = new FileInputStream(file);


        String requestBody = IOUtils.toString(fileInputStream,"UTF-8");



        baseURI = "http://www.dneonline.com";

        given().
                contentType("text/xml").
                accept(ContentType.XML).
                body(requestBody).
                when().
                post("/calculator.asmx"). //my endpoint
                then().
                statusCode(200).log().all();
    }
}
