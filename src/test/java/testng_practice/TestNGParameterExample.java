package testng_practice;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParameterExample {

    @Test(groups="smokeTest")
    @Parameters({"username", "password"})
    public void loginTest(String username, String password) {
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }
}
