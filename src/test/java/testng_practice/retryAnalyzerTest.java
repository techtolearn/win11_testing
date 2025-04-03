package testng_practice;

import org.testng.*;
import org.testng.annotations.Test;

public class retryAnalyzerTest {
    public static void main(String[] args) {
        TestNG testNg = new TestNG();
        testNg.setTestClasses(new Class[]{simpleTestRetry.class});
        testNg.run();
    }
}

class simpleTestRetry {
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void flakyTest() {
        System.out.println("Executing test...");
        assert false; // Simulating failure
    }
}

class RetryListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        if (result.getMethod().getRetryAnalyzer(result) == null) {
            result.getMethod().setRetryAnalyzerClass(RetryAnalyzer.class);
        }
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
    }
}

class RetryAnalyzer implements IRetryAnalyzer {
    private int count = 0;
    private static final int maxRetries = 2; // Retry 2 times

    @Override
    public boolean retry(ITestResult result) {
        if (count < maxRetries) {
            count++;
            return true; // Retry the test
        }
        return false; // Don't retry anymore
    }
}
