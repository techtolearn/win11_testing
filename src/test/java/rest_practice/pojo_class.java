package rest_practice;

import com.google.gson.internal.bind.util.ISO8601Utils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class pojo_class {
    public static void main(String[] args) {
        List<Email> emailList = List.of(new Email("Primary", "Testing@gmail.com"),
                new Email("Secondary", "ExampleTest@gmail.com"));

        Employee emp = new Employee(
                "Satheeshkumar",
                "SDET",
                emailList,
                new String[]{"Java", "Selenium", "Python"},
                new Details("FannieMae", "Reston")
        );

        baseURI = "https://reqres.in/api/users";
        emp.setName("Tanvi Satheesh");
        Response response = given()
                .contentType(ContentType.JSON)
                .body(emp)
                .log().all()
                .post(baseURI);

        response.getBody().prettyPrint();
        validateResponse(response);
        printResponse(response);
        getResponse();
    }

    private static void validateResponse(Response response){

        Assert.assertEquals(201, response.getStatusCode());
        Assert.assertEquals("Tanvi Satheesh", response.jsonPath().getString("name"));
        Assert.assertEquals("SDET", response.jsonPath().getString("job"));
        Assert.assertEquals("Testing@gmail.com", response.jsonPath().getString("email[0].emailValue"));
        Assert.assertEquals("Secondary", response.jsonPath().getString("email[1].emailType"));
        Assert.assertEquals("Java", response.jsonPath().getString("skills[0]"));
        Assert.assertEquals("Python", response.jsonPath().getString("skills[2]"));
        Assert.assertEquals("FannieMae", response.jsonPath().getString("details.company"));
        Assert.assertEquals("Reston", response.jsonPath().getString("details.location"));

    }

    private static void printResponse(Response response){
        System.out.println("ContentType is : "+response.getContentType());
        System.out.printf("Cookies are : " +response.getCookies());
        System.out.println("Response time is : "+response.getTime()+" ms ("+response.getTimeIn(TimeUnit.SECONDS)+")");

    }

    private static void getResponse(){
        baseURI = "https://reqres.in/api/users?page=2";
        Response response = given()
                .log().all()
                .get(baseURI);
        System.out.println("Response is : " +response.prettyPrint());

    }
}

