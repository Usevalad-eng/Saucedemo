package tests;

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
}
