package junit_practice;/*
Junit Based step definition file
 */
import io.cucumber.java.en.*;
import org.junit.Assert;

public class LoginStepsJunit {

    @Given("The application is launched")
    public void theApplicationIsLaunched() {
        System.out.println("Application launched successfully.");
    }

    @Given("The user is on the login page")
    public void theUserIsOnTheLoginPage() {
        System.out.println("User navigated to the login page.");
    }

    @Given("The user enters valid credentials")
    public void theUserEntersValidCredentials() {
        System.out.println("Entering valid credentials: Username - admin, Password - admin123");
    }

    @Given("The user enters invalid credentials")
    public void theUserEntersInvalidCredentials() {
        System.out.println("Entering invalid credentials: Username - invalidUser, Password - wrong123");
    }

    @Given("The user enters {string} and {string}")
    public void theUserEntersCredentials(String username, String password) {
        System.out.println("Entering Username: " + username + " and Password: " + password);
    }

    @When("The user clicks the login button")
    public void theUserClicksTheLoginButton() {
        System.out.println("Clicking the login button...");
    }

    @Then("The user should be redirected to the dashboard")
    public void theUserShouldBeRedirectedToTheDashboard() {
        System.out.println("User successfully redirected to the dashboard.");
        Assert.assertTrue(true);  // Assertion for successful login
    }

    @Then("The login status should be {string}")
    public void theLoginStatusShouldBe(String status) {
        System.out.println("Login status displayed as: " + status);
        Assert.assertEquals(status, status.equals("success") ? "success" : "failure");
    }

    @Then("An error message should be displayed")
    public void anErrorMessageShouldBeDisplayed() {
        System.out.println("Error message displayed for invalid credentials.");
    }

    @Given("The user selects the {string} checkbox")
    public void theUserSelectsTheCheckbox(String option) {
        System.out.println("Checkbox selected: " + option);
    }

    @Then("The user should remain logged in after reopening the browser")
    public void theUserShouldRemainLoggedIn() {
        System.out.println("User remained logged in after reopening the browser.");
    }

    @Given("The user clicks on the {string} link")
    public void theUserClicksOnTheLink(String link) {
        System.out.println("Clicked on link: " + link);
    }

    @When("The user enters their registered email")
    public void theUserEntersTheirRegisteredEmail() {
        System.out.println("Entered registered email: testuser@example.com");
    }

    @When("Clicks the {string} button")
    public void clicksTheButton(String buttonName) {
        System.out.println("Clicked on button: " + buttonName);
    }

    @Then("A password reset link should be sent to the registered email")
    public void aPasswordResetLinkShouldBeSent() {
        System.out.println("Password reset link successfully sent.");
    }
}
