package tests;

import org.testng.annotations.Test;

public class AddToBasketSaucedemo extends BaseTestSaucedemo{

    @Test
    public void loginAndAddToBasket(){
        authPage.open();
        authPage.inputLoginAndPassword("standard_user", "secret_sauce");
        authPage.clickLoginButton();
        inventoryPage.inventoryPageIsOpen();

        inventoryPage.clickAddToCartButton();
        //inventoryPage.getItemAndClickAddToCartButton("Sauce Labs Backpack");

        inventoryPage.clickBasketButton();
    }
}
