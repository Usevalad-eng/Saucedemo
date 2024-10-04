package tests;

import org.testng.annotations.Test;

public class InventoryTestSaucedemo extends BaseTestSaucedemo {

    @Test
    public void loginAndAddToBasket() {
        authPage.login();
        inventoryPage.clickAddToCartButton();
        //inventoryPage.getItemAndClickAddToCartButton("Sauce Labs Backpack"); //todo
        inventoryPage.clickBasketButton();
        driver.navigate().back();
        inventoryPage.inventoryPageIsOpen();
    }
}
