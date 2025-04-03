package testng_practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class TestNGAdvancedDemo {
    public TestNGAdvancedDemo() throws SQLException {
    }

    @BeforeSuite
    public void beforeSuite() throws IOException {
        System.out.println("Before Suite - Setting up system properties");
        // Example: Setting system properties for browser drivers
        Properties config = new Properties();
        FileInputStream fis = new FileInputStream("config.properties");
        config.load(fis);
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        // Example: Initializing configurations
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Global test setup is completed.");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test - Creating test data for the <test> tag in XML");
    }
    // You can set up test data, configurations, or database connections here.
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "user", "password");
    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class - Opening browser");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method - Navigating to application");
    }

    @Test(priority = 1, groups = "Smoke", enabled = true)
    public void loginTest() {
        System.out.println("Test - Verifying Login Functionality");
        Assert.assertTrue(true, "Login successful");
    }

    @Test(priority = 2, groups = "Regression", dependsOnMethods = "loginTest")
    public void dashboardTest() {
        System.out.println("Test - Verifying Dashboard Elements");
        Assert.assertEquals(5, 5, "Dashboard verified");
    }

    @Test(priority = 3, groups = "Sanity", enabled = false)
    public void logoutTest() {
        System.out.println("Test - Verifying Logout Functionality");
    }

    @Test(priority = 4, expectedExceptions = NumberFormatException.class)
    public void numberFormatExceptionTest() {
        System.out.println("Test - Expecting NumberFormatException");
        Integer.parseInt("InvalidNumber");  // This will throw NumberFormatException
    }

    @Test(priority = 5, invocationCount = 3)
    public void repeatTest() {
        System.out.println("Test - Running this test multiple times");
    }

    @Test(priority = 6)
    @Parameters({"username", "password"})
    public void parameterizedTest(String user, String pass) {
        System.out.println("Test - Verifying login with: " + user + " / " + pass);
        Assert.assertTrue(user.equals("admin") && pass.equals("admin123"), "Credentials verified");
    }

    @Test(timeOut = 2000)  // Test will fail if it exceeds 2 seconds
    public void testWithTimeout() throws InterruptedException {
        Thread.sleep(3000);  // Simulating a delay (3 seconds)
        System.out.println("This test will fail due to timeout.");
    }
    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method - Logging out");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class - Closing browser");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test - Cleaning up test data for the <test> tag in XML");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite - Cleanup system properties");
    }
}
