package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AuthTestSaucedemo extends BaseTestSaucedemo {

    public String passFieldIsEmptyMessage = "Epic sadface: Password is required";

    @Test
    public void userShouldBeAuthorisedUsingValidData() {
        authPage.open();
        authPage.inputLoginAndPassword("standard_user", "secret_sauce");
        authPage.clickLoginButton();
        inventoryPage.inventoryPageIsOpen();
    }

   /* @Test
    public void userShouldBeAuthorisedUsingValidDataV2(){
        authPage.open();
        authPage.inputLoginAndPasswordNotVoid("standard_user", "secret_sauce")
                .clickLoginButtonNotVoid();
        boolean pageIsOpen = inventoryPage.inventoryPageIsOpen();
        assertTrue(pageIsOpen, "Inventory page is not open");
    }*/

    @Test
    public void userShouldNotBeAuthorisedUsingInvalidDataPasswordIsEmpty() {
        authPage.open();
        authPage.inputLoginAndPassword("standard_user", "");
        authPage.clickLoginButton();
        String errorMessage = authPage.getErrorMessage();
        assertEquals(errorMessage, passFieldIsEmptyMessage, "Password is required");
    }

    /*@Test
    public void userShouldNotBeAuthorisedUsingInvalidDataPasswordIsEmptyV2(){
        String errorMessage = authPage.openNotVoid()
                .inputLoginAndPasswordNotVoid("standard_user", "")
                .clickLoginButtonNotVoid()
                .getErrorMessage();
        assertEquals(errorMessage, passFieldIsEmptyMessage, "Passwore is required");
    }*/

    @Test
    public void userShouldNotBeAuthorisedUsingInvalidDataUsernameIsEmpty() {
        authPage.open();
        authPage.inputLoginAndPassword("", "secret_sauce");
        authPage.clickLoginButton();
        String errorMessage = authPage.getErrorMessage();
        assertEquals(errorMessage, "Epic sadface: Username is required", "Username is required");
    }

    @Test
    public void userShouldNotBeAuthorisedUsingInvalidDataUsernameAndPasswordAreEmpty() {
        authPage.open();
        authPage.inputLoginAndPassword("", "secret_sauce");
        authPage.clickLoginButton();
        String errorMessage = authPage.getErrorMessage();
        assertEquals(errorMessage, "Epic sadface: Username is required", "Username and pwd are required");
    }

    @Test
    public void userShouldNotBeAuthorisedUsingInvalidData() {
        authPage.open();
        authPage.inputLoginAndPassword("name", "password");
        authPage.clickLoginButton();
        String errorMessage = authPage.getErrorMessage();
        assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service");
    }
}
