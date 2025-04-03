package rest_practice;

import io.restassured.builder.ResponseBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.TestNG;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class createMockAPI {

    public static void main(String[] args){
        TestNG testNG = new TestNG();
        testNG.setTestClasses(new Class[]{mockApiJson.class});
        testNG.run();

    }
}
class mockApiJson{
    @Test
    public void testMockApi() throws IOException {
        String jsonResponse = new String(Files.readAllBytes(Paths.get("src/test/resources/testdata/mockResponseApi.json")));

        Response response = new ResponseBuilder()
                .setBody(jsonResponse)
                .setContentType(ContentType.JSON)
                .setStatusCode(200)
                .build();
        System.out.println("Response code "+response.getStatusCode());
        //System.out.println("Response body "+response.body().prettyPrint());

        System.out.println("Response message :"+response.jsonPath().get("message"));
        System.out.println("Response Success :"+response.jsonPath().get("Status"));

        System.out.println("Id : "+response.jsonPath().get("data.id"));
        System.out.println("emailId : "+response.jsonPath().get("data.email[0].emailId"));
        System.out.println("Skills :"+response.jsonPath().get("data.skills[0]"));
        System.out.println("Details : "+response.jsonPath().get("data.details.companyName"));
    }
}
