package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckItem extends BaseTestSaucedemo{

    @Test
    public void checkItem(){
        authPage.open();
        authPage.inputLoginAndPassword("standard_user", "secret_sauce");
        authPage.clickLoginButton();
        inventoryPage.inventoryPageIsOpen();
        inventoryPage.clickAddToCartButton();
        inventoryPage.clickBasketButton();

        String firstItem = cartPage.getFirstItem();
        assertEquals(firstItem, "Sauce Labs Backpack", "Error, not right item added.");

        String firstItemPrice = cartPage.getFirstItemPrice();
        assertEquals(firstItemPrice, "$29.99", "Error, not right item added (cost is not equal).");
    }
}
