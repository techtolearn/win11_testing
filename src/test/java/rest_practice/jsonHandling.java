package rest_practice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.opentelemetry.sdk.resources.Resource;
import io.restassured.response.Response;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class jsonHandling {

    public static void main(String[] args) throws IOException {

        multipart_upload();
        multipart_download();
        json_compare();
        json_read();
    }

    private static final String UPLOAD_URL =  "https://the-internet.herokuapp.com/upload";
    private static final String UPLOAD_FILE_PATH = "/Users/satyi/Downloads/multipart.jpg";
    private static final String DOWNLOAD_URL = "https://reqres.in/api/users?page=2";
    private static final String DOWNLOAD_FILE_PATH =  "/Users/satyi/Downloads/test1231.json";

    private static void multipart_upload() {
        File file = new File(UPLOAD_FILE_PATH);

        Response response = given()
                .multiPart("file", file)
                .post(UPLOAD_URL);

        System.out.println(response.prettyPrint());

    }

    private static void multipart_download() throws IOException {
        byte[] bytes = given()
                .get(DOWNLOAD_URL)
                .getBody()
                .asByteArray();
        Files.write(new File(DOWNLOAD_FILE_PATH).toPath(), bytes);

    }

    private static void json_compare() throws JsonProcessingException {

        String file1 = "{\"FirstName\":\"Satheesh\",\"LastName\":\"Kumar\",\"Skills\":[\"Java\",\"Python\",\"Selenium\"]}";
        String file2 = "{\"FirstName\":\"Satheesh\",\"LastName\":\"Kumar\",\"Skills\":[\"Java\",\"Python\",\"Selenium\"]}";

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node1 = objectMapper.readTree(file1);
        JsonNode node2 = objectMapper.readTree(file2);

        System.out.println("Are these json same : " + node1.equals(node2));
    }

    private static void json_read() throws IOException {
        File file = new File(getFilePath("userApi.json"));
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node = objectMapper.readTree(file);

        JsonNode dataArray = node.get("data");
        if (dataArray != null && dataArray.isArray()) {
            String[] id = new String[dataArray.size()];
            for (int i = 0; i < dataArray.size(); i++) {
                id[i] = dataArray.get(i).get("id").asText();
            }
            System.out.println(Arrays.toString(id));
        } else {
            System.out.println("No data array found in the given Json");
        }

    }

    private static String getFilePath(String fileName) {
        return Paths.get("src/test/resources/testdata", fileName).toAbsolutePath().toString();
    }
}
