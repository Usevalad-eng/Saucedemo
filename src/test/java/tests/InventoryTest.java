package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InventoryTest extends BaseTest {
    @Test
    public void loginAndAddToBasket() {
        authPage.login();
        inventoryPage.getItemAndClickAddToCartButton("Sauce Labs Backpack");
        inventoryPage.clickBasketButton();
        driver.navigate().back();
        inventoryPage.inventoryPageIsOpen();
    }

    @Test
    public void logoutTest() {
        authPage.login();
        driver.findElement(By.id("react-burger-menu-btn")).click();
        inventoryPage.logoutClick();
        driver.findElement(By.id("logout_sidebar_link")).click();
        WebElement expected = driver.findElement(By.xpath("//div[@class = 'login_logo']"));
        Assert.assertTrue(expected.isDisplayed());
    }

    @Test
    public void getFirstItemNameAndPrice() {
        authPage.login();
        inventoryPage.getFirstItemName();
        inventoryPage.getFirstItemPrice();
        System.out.println("I'v got it!");
    }
}
