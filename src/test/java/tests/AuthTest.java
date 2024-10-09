package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AuthPage;

import static org.testng.Assert.assertEquals;

public class AuthTest extends BaseTest {

    public String passFieldIsEmptyMessage = "Epic sadface: Password is required";

    @Test
    public void userShouldBeAuthorisedUsingValidData() {
        authPage.open();
        authPage.inputLoginAndPassword("standard_user", "secret_sauce");
        authPage.clickLoginButton();
        inventoryPage.inventoryPageIsOpen();
    }

    @Test
    public void userShouldNotBeAuthorisedUsingInvalidDataPasswordIsEmpty() {
        authPage.open();
        authPage.inputLoginAndPassword("standard_user", "");
        authPage.clickLoginButton();
        String errorMessage = authPage.getErrorMessage();
        assertEquals(errorMessage, passFieldIsEmptyMessage, "Password is required");
    }

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

    @Test
    public void lockedUserShouldNotBeAuthorised(){
        authPage.open();
        authPage.inputLoginAndPassword("locked_out_user", "secret_sauce");
        authPage.clickLoginButton();
        String errorMessage = authPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Epic sadface: Sorry, this user has been locked out.", "Not OK!");
        authPage.clickCloseErrorMessageButton();
        Assert.assertTrue(authPage.errorMessageBlockIsClosed(), "something went wrong!");
    }
}
