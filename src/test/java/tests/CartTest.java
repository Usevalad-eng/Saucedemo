package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CartTest extends BaseTest {
    @Test
    public void checkItem() {
        authPage.login();
        inventoryPage.clickAddToCartButton();
        inventoryPage.clickBasketButton();
        cartPage.setWait();
        String firstItem = cartPage.getFirstItem();
        assertEquals(firstItem, "Sauce Labs Backpack", "Error, not right item added.");
        String firstItemPrice = cartPage.getFirstItemPrice();
        assertEquals(firstItemPrice, "$29.99", "Error, not right item added (cost is not equal).");
    }

    @Test
    public void checkItemAndFindCheckout() {
        authPage.login();
        inventoryPage.clickAddToCartButton();
        inventoryPage.clickBasketButton();
        cartPage.setWait();
        String firstItem = cartPage.getFirstItem();
        assertEquals(firstItem, "Sauce Labs Backpack", "Error, not right item added.");
        String firstItemPrice = cartPage.getFirstItemPrice();
        assertEquals(firstItemPrice, "$29.99", "Error, not right item added (cost is not equal).");
        driver.findElement(By.id("checkout"));
        //assert todo
    }

    @Test
    public void testRemoveElements() {
        authPage.login();
        inventoryPage.getItemAndClickAddToCartButton("Sauce Labs Backpack");
        inventoryPage.getItemAndClickAddToCartButton("Sauce Labs Bolt T-Shirt");
        inventoryPage.clickBasketButton();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[text()='Your Cart']")));
        cartPage.removeAllItems_();
        System.out.println("All items removed");
        cartPage.setWait();
        Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[text() = 'Remove']"))));
    }
}
