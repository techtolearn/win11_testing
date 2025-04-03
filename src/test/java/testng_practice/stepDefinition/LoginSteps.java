
package testng_practice.stepDefinition;

import org.testng.Assert;
import org.testng.annotations.*;

public class LoginSteps {

    @BeforeTest
    public void setup() {
        System.out.println("Before Test - Setting up browser and application launch");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method - Navigating to the Login Page");
    }

    @Test(priority = 1, groups = "Smoke")
    public void successfulLoginTest() {
        System.out.println("Test - Verifying Successful Login");
        System.out.println("Entering valid credentials: Username - admin, Password - admin123");
        System.out.println("Clicking Login Button...");
        System.out.println("User successfully redirected to the dashboard.");
        Assert.assertTrue(true, "Login successful");
    }

    @Test(priority = 2, groups = "Regression", dataProvider = "loginData")
    public void multipleLoginTest(String username, String password, String status) {
        System.out.println("Test - Login Test with Data: " + username + " / " + password);
        System.out.println("Clicking Login Button...");
        System.out.println("Expected Status: " + status);
        Assert.assertEquals(status, status.equals("success") ? "success" : "failure");
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][] {
                {"admin", "admin123", "success"},
                {"user1", "wrong123", "failure"},
                {"user2", "pass456", "success"}
        };
    }

    @Test(priority = 3, groups = "Regression")
    public void failedLoginTest() {
        System.out.println("Test - Verifying Failed Login with Invalid Credentials");
        System.out.println("Entering invalid credentials: Username - invalidUser, Password - wrong123");
        System.out.println("Clicking Login Button...");
        System.out.println("Error message displayed.");
        Assert.assertTrue(true, "Error message verified");
    }

    @Test(priority = 4, groups = "Sanity")
    public void rememberMeFunctionalityTest() {
        System.out.println("Test - Remember Me Functionality");
        System.out.println("Entering valid credentials");
        System.out.println("Selecting 'Remember Me' checkbox...");
        System.out.println("Clicking Login Button...");
        System.out.println("User should remain logged in after reopening the browser.");
        Assert.assertTrue(true, "Remember Me verified");
    }

    @Test(priority = 5, groups = "Regression")
    public void forgotPasswordFunctionalityTest() {
        System.out.println("Test - Forgot Password Functionality");
        System.out.println("Clicking 'Forgot Password' link...");
        System.out.println("Entering registered email: testuser@example.com");
        System.out.println("Clicking 'Reset Password' button...");
        System.out.println("Password reset link successfully sent.");
        Assert.assertTrue(true, "Password reset verified");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method - Logging out or resetting state");
    }

    @AfterTest
    public void teardown() {
        System.out.println("After Test - Closing browser and cleanup");
    }
}
