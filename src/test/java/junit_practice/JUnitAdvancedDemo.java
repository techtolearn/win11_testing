package selenium_practice;

import org.junit.*;
import static org.junit.Assert.*;

public class JUnitAdvancedDemo {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before Class - Runs once before all tests in the class");
    }

    @Before
    public void beforeMethod() {
        System.out.println("Before Each Test - Setting up data");
    }

    @Test
    public void testAddition() {
        System.out.println("Test Addition - Verifying addition logic");
        assertEquals(10, 5 + 5);
    }

    @Test(timeout = 2000)  // Test should complete within 2 seconds
    public void testWithTimeout() throws InterruptedException {
        System.out.println("Test Timeout - Simulating a fast process");
        Thread.sleep(1000);  // Within the limit
    }

    @Test(expected = ArithmeticException.class) // Expected exception handling
    public void testException() {
        System.out.println("Test Exception - Checking ArithmeticException");
        int result = 10 / 0;  // This will throw ArithmeticException
    }

    @Ignore("Skipping this test due to ongoing development")
    @Test
    public void skippedTest() {
        System.out.println("Skipped Test - Won't run");
    }

    @Test
    public void conditionalTest() {
        boolean skipCondition = true;
        if (skipCondition) {
            System.out.println("Skipping this test based on condition");
            Assume.assumeTrue(false);  // Conditionally skip the test
        }
        System.out.println("This test will not run");
    }

    @After
    public void afterMethod() {
        System.out.println("After Each Test - Cleaning data");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After Class - Runs once after all tests are completed");
    }
}
