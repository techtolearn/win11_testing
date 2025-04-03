package rest_practice;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class jsonCreateAndPost {
    public static void main(String[] args) throws JSONException {
        jsonCreatePost();
        jsonCreatePost1();
        createXMLPayloadAndPost();

    }

    public static void jsonCreatePost() throws JSONException {
        String[] skills = {"Selenium", "Python", "Java"};

        List<Map<String, String>> email = new ArrayList<>();

        Map<String, String> email1 = new HashMap<>();
        email1.put("emailType", "Primary");
        email1.put("emialId", "Satheeshkumar@gmail.com");

        Map<String, String> email2 = new HashMap<>();
        email2.put("emailType", "Secondary");
        email2.put("emialId", "Ramesh@gmail.com");

        email.add(email1);
        email.add(email2);
        // Convert List to JSONArray
        JSONArray emailArray = new JSONArray(email);

        Map<String, String> companyInfo = new HashMap<>();
        companyInfo.put("companyName", "FannieMaie");
        companyInfo.put("companyLocation", "Restonst");

        JSONObject details = new JSONObject(companyInfo);

        JSONObject emp = new JSONObject();
        emp.put("name", "Satheeshkumar");
        emp.put("job", "Satheeshkumar");
        emp.put("emails", emailArray);
        emp.put("skills", skills);
        emp.put("detail", details);


        baseURI = "https://reqres.in/api/users";
        Response response = given()
                .contentType(ContentType.JSON)
                .body(emp.toString()) //  Convert JSONObject to String
                .post(baseURI);
        System.out.println("response body = " + response.getBody().prettyPrint());
        System.out.println("response code = " + response.getStatusCode());
    }

    public static void jsonCreatePost1() throws JSONException {
        JSONObject payload = new JSONObject();
        payload.put("username", "test_user");
        payload.put("email", "testuser@example.com");
        payload.put("role", "admin");

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(payload.toString())    // Convert JSONObject to String
                .post("https://example.com/api/users");

        System.out.println("Response Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());
    }
    public static void createXMLPayloadAndPost() {
        String xmlPayload = "<user>" +
                "<username>test_user</username>" +
                "<email>testuser@example.com</email>" +
                "<role>admin</role>" +
                "</user>";

        Response response = RestAssured.given()
                .header("Content-Type", "application/xml")
                .body(xmlPayload)
                .post("https://example.com/api/users");

        System.out.println("Response Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());
    }

}
