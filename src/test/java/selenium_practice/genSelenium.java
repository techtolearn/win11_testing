package selenium_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class genSelenium {
    public static void main(String[] args) throws AWTException {
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

        String parent = driver.getWindowHandle();
        Set<String> set = driver.getWindowHandles();
        Iterator<String> itr  = set.iterator();
        while(itr.hasNext()){
            String child = itr.next();
            driver.switchTo().window(child).getCurrentUrl();
            driver.close();
        }
        driver.switchTo().window(parent).getTitle();
        driver.close();

        Alert alert = driver.switchTo().alert();
        alert.accept();
        alert.dismiss();

        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_SHIFT);
        r.keyRelease(KeyEvent.VK_SHIFT);








    }
}
