/*
use the TestRunner class to execute
 */
package testng_practice;

import org.testng.TestNG;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDataProviderExample {
    public static void main(String[] args){
        TestNG testNg = new TestNG();
        testNg.setTestClasses(new Class[] {dataProviderEx.class});
        testNg.run();
    }
}
class dataProviderEx{
    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) {
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }

    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return new Object[][] {
                {"user1", "pass1"},
                {"user2", "pass2"},
                {"admin", "admin123"}
        };
    }
}
