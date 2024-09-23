import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class AuthTest extends BaseTest{
    private static final String URL = "https://www.saucedemo.com/";

    @Test
    public void loginPageEnteringSuccess(){
        driver.get(URL);
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword!");
        WebElement loginButton = driver.findElement(By.className("fa-sign-in"));
        loginButton.click();

        WebElement success = driver.findElement(By.id("flash"));
        boolean displayed = success.isDisplayed();

        assertTrue(displayed, "Error");
    }

    @Test
    public void loginPageEnteringNotSuccess(){
        driver.get(URL);
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");
        WebElement password = driver.findElement(By.id("password"));
        username.sendKeys("SuperSecret");
        WebElement loginButton = driver.findElement(By.className("fa-sign-in"));
        loginButton.click();

        WebElement unsuccessMessage = driver.findElement(By.xpath("//*[@id='flash']"));
        boolean displayed = unsuccessMessage.isDisplayed();

        assertTrue(displayed, "Error");
    }
}
