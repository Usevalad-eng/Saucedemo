package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AuthTest extends BaseTest {

    public String passFieldIsEmptyMessage = "Epic sadface: Password is required";

    @DataProvider(name = "negative tests")
    public Object[][] inputForTask() {
        return new Object[][]{
                {"name", "password", "Epic sadface: Username and password do not match any user in this service"},
                {"n", "p", "Epic sadface: Username and password do not match any user in this service"},
                {"na", "pa", "Epic sadface: Username and password do not match any user in this service"},
        };
    }
    @Test(description = "userShouldBeAuthorisedUsingValidData",
            invocationCount = 1)
    @Parameters({"login"})
    public void userShouldBeAuthorisedUsingValidData(@Optional("standard_user") String login) {
        authPage.open();
        authPage.isPageOpened();
        authPage.inputLoginAndPassword(login, "secret_sauce");
        authPage.clickLoginButton();
        inventoryPage.inventoryPageIsOpen();
    }

    @Test (dataProvider = "negative tests")
    public void negativeLoginTest(String login, String pass, String error) {
        authPage.open();
        authPage.inputLoginAndPassword(login, pass);
        authPage.clickLoginButton();
        String actualErrorMessage = authPage.getErrorMessage();
        assertEquals(actualErrorMessage, error, "something went wrong");
    }

    @Test(description = "problem user")
    public void problemUserShouldBeAuthorisedUsingValidData() {
        authPage.open();
        authPage.isPageOpened();
        authPage.inputLoginAndPassword("problem_user", "secret_sauce");
        authPage.clickLoginButton();
        inventoryPage.inventoryPageIsOpen();
    }

    @Test
    public void performanceUserShouldBeAuthorisedUsingValidData() {
        authPage.open();
        authPage.isPageOpened();
        authPage.inputLoginAndPassword("performance_glitch_user", "secret_sauce");
        authPage.clickLoginButton();
        inventoryPage.inventoryPageIsOpen();
    }

    @Test(description = "error user test")
    public void errorUserShouldBeAuthorisedUsingValidData() {
        authPage.open();
        authPage.isPageOpened();
        authPage.inputLoginAndPassword("error_user", "secret_sauce");
        authPage.clickLoginButton();
        inventoryPage.inventoryPageIsOpen();
    }

    @Test
    public void visualUserShouldBeAuthorisedUsingValidData() {
        authPage.open();
        authPage.isPageOpened();
        authPage.inputLoginAndPassword("visual_user", "secret_sauce");
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

    @Test(groups = "fast")
    public void userShouldNotBeAuthorisedUsingInvalidDataUsernameAndPasswordAreEmpty() {
        authPage.open();
        authPage.inputLoginAndPassword("", "");
        authPage.clickLoginButton();
        String errorMessage = authPage.getErrorMessage();
        assertEquals(errorMessage, "Epic sadface: Username is required", "Username and pwd are required");
    }

    @Test (groups = "slow")
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
        Assert.assertTrue(authPage.errorMessageBlockIsClosed(), "Something went wrong!");
    }

    @Test
    public void ordinaryUserShouldBeAuthorisedUsingValidData() {
        authPage.open();
        authPage.isPageOpened();
        authPage.inputLoginAndPassword("standard_user", "secret_sauce");
        authPage.clickLogin();
        inventoryPage.inventoryPageIsOpen();
    }
}
