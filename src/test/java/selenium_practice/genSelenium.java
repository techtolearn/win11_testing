package selenium_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;
import java.util.List;
import java.util.function.Function;

public class genSelenium {
    public static void main(String[] args) throws AWTException, IOException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        WebDriver driver = new ChromeDriver(opt);

        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com");

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.example.com");

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.testing.com");

        driver.switchTo().frame(0);
        driver.close();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("testing")));


        FluentWait<WebDriver> wait1 = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30)) // Maximum wait time
                .pollingEvery(Duration.ofSeconds(5)) // Check every 5 seconds
                .ignoring(NoSuchElementException.class); // Ignore specific exception
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("ddgsad")));



        String parent = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows)
            driver.switchTo().window(window).close();

        driver.switchTo().window(parent).getTitle();
        driver.close();

        Alert alert = driver.switchTo().alert();
        alert.accept();
        alert.dismiss();

        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_SHIFT);
        r.keyRelease(KeyEvent.VK_SHIFT);

        Select select = new Select(driver.findElement(By.xpath("//div[@contains(text ='423'")));
        select.selectByVisibleText("Testing");
        select.selectByIndex(1);
        select.selectByValue("3423");
        select.deselectAll();

        Actions action = new Actions(driver);
        action.click(driver.findElement(By.tagName("")));
        action.clickAndHold(driver.findElement(By.className("4332")));
        action.dragAndDrop(driver.findElement(By.id("")), driver.findElement(By.linkText("")));

        driver.findElement(RelativeLocator.with(By.xpath("\\[@id=43123")).near(By.xpath("\\div[@classname='']")));
        driver.findElement(RelativeLocator.with(By.tagName("")).below(By.partialLinkText("")));
        driver.findElement(RelativeLocator.with(By.className("")).above(By.linkText("")));
        driver.findElement(RelativeLocator.with(By.className("")).toLeftOf(By.linkText("")));
        WebElement element = driver.findElement(RelativeLocator.with(By.className("")).toRightOf(By.linkText("")));

        List<WebElement> elements = driver.findElements(By.xpath("//div[@tagname= '']"));
           for(WebElement el : elements)
               System.out.println(el.getText());

         JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("argument[0].click()",elements);

        String file1 = getScreenShot(driver, "Test1");
        String file2 = getScreenShot(element,"Test2");
    }
    private static String getScreenShot(WebDriver driver, String scrName) throws IOException {
        String date = new SimpleDateFormat("DDmmyyyy").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        String fileName = System.getProperty("user.dir") +"/testcaase/"+scrName+date+".jpeg";
        File destn = new File(fileName);
        FileUtils.copyDirectory(src, destn);
        return fileName;
    }

    private static String getScreenShot(WebElement element, String scrName) throws IOException {
        String date = new SimpleDateFormat("DDmmyyyy").format(new Date());
        //TakesScreenshot ts = (TakesScreenshot) driver;
        File src = element.getScreenshotAs(OutputType.FILE);
        String fileName = System.getProperty("user.dir") +"/testcaase/"+scrName+date+".jpeg";
        File destn = new File(fileName);
        FileUtils.copyDirectory(src, destn);
        return fileName;
    }

    public static WebElement fluentWait(WebDriver driver, By locator, int timeout, int pollingTime) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);

        return wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement element = driver.findElement(locator);
                if (element.isDisplayed()) {
                    return element;
                }
                return null;
            }
        });
    }
}
