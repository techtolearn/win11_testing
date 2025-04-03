/*
Page factory implementation
 */
package selenium_practice;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginTest {
    WebDriver driver;
    @FindBy(id= "userName")
    WebElement username;
    @FindBy(id= "Passsword")
    WebElement Password;

    @FindBy(id ="button")
    WebElement button;

    public LoginTest(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void enterUserName(String userName){
        username.sendKeys(userName);
    }

    public void enterPassword(String password){
        Password.sendKeys(password);
    }

    public void clickLogin(){
        button.click();
    }
}

class LoginPage{
    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        WebDriver driver = new ChromeDriver(opt);
        driver.get("https://google.com");
        LoginTest loginTest = new LoginTest(driver);
        loginTest.enterUserName("satheesh");
        loginTest.enterPassword("password");
        loginTest.clickLogin();

    }

}
