package rest_practice;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;


import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class emp_poj {
    public static void main(String[] args) {
        List<Email> emailList = List.of(new Email("Primary", "Satheesh@gmail.com"),
                new Email("Secondary", "Test@gmail.com"));
        Employee emp = new Employee(
                "Satheeshkumar",
                "SDET",
                emailList,
                new String[]{"Java", "Python", "Selenium"},
                new Details("Fanniemae","Reston")
        );


        baseURI = "https://reqres.in/api/users/page=2";
        Response response = given()
                .contentType(ContentType.JSON)
                .body(emp)
                .log().all()
                .post(baseURI);
        System.out.println("Post Response is : " + response.prettyPrint());

        validateResponse(response);
        printResonse(response);
        getApiResponse();
    }

    private static void validateResponse(Response response){
        Assert.assertEquals(201, response.statusCode());
        Assert.assertEquals("Satheeshkumar", response.jsonPath().get("name"));
        Assert.assertEquals("SDET", response.jsonPath().get("job"));
        Assert.assertEquals("Primary", response.jsonPath().get("email[0].emailType"));
        Assert.assertEquals("Test@gmail.com", response.jsonPath().get("email[1].emailId"));
        Assert.assertEquals("Java", response.jsonPath().get("skills[0]"));
        Assert.assertEquals("Selenium", response.jsonPath().get("skills[2]"));
        Assert.assertEquals("Fanniemae", response.jsonPath().get("details.companyName"));
        Assert.assertEquals("Reston", response.jsonPath().get("details.location"));
    }

    private static void printResonse(Response response){
        System.out.println("contentType is  : "+response.contentType());
        System.out.println("Cookies : "+response.cookies());
        System.out.println("Response Time : "+response.time()+" ms ("+response.timeIn(TimeUnit.SECONDS)+")");
    }

    private static void getApiResponse(){
        baseURI = "https://reqres.in/api/users?page=2";
        Response response = given()
                .log().all()
                .get(baseURI);

        System.out.println("Get API Resposne is : "+response.prettyPrint());

    }
}
