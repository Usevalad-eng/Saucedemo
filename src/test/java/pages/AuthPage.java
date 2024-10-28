package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static pages.InventoryPage.PRODUCT_LABEL;

public class AuthPage extends BasePage {

    public static final By USERNAME = By.id("user-name");
    public static final By PASSWORD = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");

    @FindBy(id = "login-button")
    WebElement loginButton;

    public static final By ERROR_MESSAGE = By.xpath("//h3[@data-test='error']");

    public static final By CLOSE_ERROR_MESSAGE = By.xpath("//button[@class='error-button']");


    public AuthPage(WebDriver driver) {
        super(driver);
    }

    public void inputLoginAndPassword(String name, String password) {
        driver.findElement(USERNAME).sendKeys(name);
        driver.findElement(PASSWORD).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void clickLogin(){
        loginButton.click();
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    public void open() {
        driver.get(URL);
    }

    public boolean isPageOpened() {
        return isPageExist(LOGIN_BUTTON);
    }

    public void login() {
        driver.get(URL);
        driver.findElement(USERNAME).sendKeys("standard_user");
        driver.findElement(PASSWORD).sendKeys("secret_sauce");
        driver.findElement(LOGIN_BUTTON).click();
        Assert.assertTrue(driver.findElement(PRODUCT_LABEL).isDisplayed());
    }

    public void clickCloseErrorMessageButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(CLOSE_ERROR_MESSAGE)).click();
    }

    public boolean errorMessageBlockIsClosed(){
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(CLOSE_ERROR_MESSAGE));
    }
}
