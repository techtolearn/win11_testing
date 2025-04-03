package reportUtil;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestReport {
    private static ExtentReports extent;

    @BeforeSuite
    public void setupReport() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
    }

    @Test
    public void testExample() {
        ExtentTest test = extent.createTest("Sample Test");
        test.pass("Test passed successfully!");
    }

    @AfterSuite
    public void tearDown() {
        extent.flush();  // Generates the report
    }
}
