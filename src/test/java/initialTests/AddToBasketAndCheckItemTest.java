package initialTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddToBasketAndCheckItemTest extends Base_Test {
    private String uname = "%s";
    private static final By PASS = By.id("password");

    @Test
    public void clickOnForm() {
        driver.get("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.xpath("//*[@id='user-name']"));

        username.sendKeys(String.format("standard_user", uname));
        WebElement password = driver.findElement(PASS);
        password.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement logo = driver.findElement(By.cssSelector("[class='app_logo']"));
        assertTrue(logo.isDisplayed(), "You are not entered the system");
    }

    @Test
    public void addItemToBasketAndCheck() {
        driver.get("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.xpath("//*[@id='user-name']"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(PASS);
        password.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCartButton.click();
        WebElement basketButton = driver.findElement(By.xpath("//a[@data-test='shopping-cart-link']"));
        basketButton.click();

        String itemActual = driver.findElement(By.cssSelector("[data-test='inventory-item-name']")).getText();
        String itemExpected = "Sauce Labs Backpack";
        assertEquals(itemActual, itemExpected, "Error, not right item added.");

        String itemCostActualInitial = driver.findElement(By.cssSelector("[data-test='inventory-item-price']")).getText();
        String str = itemCostActualInitial.substring(1);
        double itemCostActual = Double.parseDouble(str);
        double itemCostExpected = 29.99;
        assertEquals(itemCostActual, itemCostExpected, "Error, cost doesn't match");
    }
}
