package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AuthPage extends BasePage{

    //WebDriver driver;
    /*public AuthPage(WebDriver driver) {
        this.driver = driver;
    }*/

    public static final By USERNAME = By.id("user-name");
    public static final By PASSWORD = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final By ERROR_MESSAGE = By.xpath("//h3[@data-test='error']");

    //public static final String URL = "https://www.saucedemo.com/";

    public AuthPage(WebDriver driver) {
        super(driver);
    }

    public void inputLoginAndPassword(String name, String password){
        driver.findElement(USERNAME).sendKeys(name);
        driver.findElement(PASSWORD).sendKeys(password);
    }
    public AuthPage inputLoginAndPasswordNotVoid(String name, String password){
        driver.findElement(USERNAME).sendKeys(name);
        driver.findElement(PASSWORD).sendKeys(password);
        return this;
    }

    public void clickLoginButton(){
        driver.findElement(LOGIN_BUTTON).click();
    }
    public AuthPage clickLoginButtonNotVoid(){
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }
    public String getErrorMessage(){
        return driver.findElement(ERROR_MESSAGE).getText();
    }
    public void open(){
        driver.get(URL);
    }
    public AuthPage openNotVoid(){
        driver.get(URL);
        return this;
    }
}
