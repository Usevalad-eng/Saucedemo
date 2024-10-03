package tests;

import org.testng.annotations.Test;

public class InventoryTestSaucedemo extends BaseTestSaucedemo {

    @Test
    public void loginAndAddToBasket() {
        authPage.open();
        authPage.inputLoginAndPassword("standard_user", "secret_sauce");
        authPage.clickLoginButton();
        inventoryPage.inventoryPageIsOpen();
        inventoryPage.clickAddToCartButton();
        inventoryPage.clickBasketButton();
    }
}
