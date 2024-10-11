package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutCompleteTest extends BaseTest {

    @Test
    public void checkoutOnStepOnePage() {
        authPage.login();
        inventoryPage.clickAddToCartButton();
        inventoryPage.clickBasketButton();
        cartPage.setWait();
        String firstItem = cartPage.getFirstItem();
        assertEquals(firstItem, "Sauce Labs Backpack", "Error, not right item added.");
        String firstItemPrice = cartPage.getFirstItemPrice();
        assertEquals(firstItemPrice, "$29.99", "Error, not right item added (cost is not equal).");
        driver.findElement(By.id("checkout")).click();
        checkoutStepOnePage.setWait();
        Assert.assertTrue(driver.findElement(By.xpath("//span[@data-test = 'title']")).isDisplayed(),
                "Title is not displayed!");
        driver.findElement(By.id("first-name")).sendKeys("Bob");
        driver.findElement(By.id("last-name")).sendKeys("Torn");
        driver.findElement(By.id("postal-code")).sendKeys("55555");
        driver.findElement(By.id("continue")).click();
        checkoutStepTwoPage.setWait();
        Assert.assertTrue(driver.findElement(By.xpath("//span[@data-test = 'title']")).isDisplayed(),
                "Title is not displayed!");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@data-test = 'total-label']")).getText(),
                "Total: $32.39", "Error: total price doesn't match!");
        Assert.assertTrue(driver.findElement(By.xpath("//button[@id = 'finish']")).isDisplayed(),
                "Finish button is not displayed!");
        driver.findElement(By.id("finish")).click();
        checkoutCompletePage.setWait();
        Assert.assertTrue(driver.findElement(By.xpath("//span[text() = 'Checkout: Complete!']")).isDisplayed(),
                "Title is not displayed!");
        Assert.assertTrue(driver.findElement(By.id("back-to-products")).isDisplayed(),
                "Finish button is not displayed!");
        driver.findElement(By.id("back-to-products")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//span[@data-test = 'title']")).isDisplayed(),
                "!Error, can't find title of the page!");
        inventoryPage.setWait();
        driver.findElement(By.id("react-burger-menu-btn")).click();
        inventoryPage.logoutClick();
        driver.findElement(By.id("logout_sidebar_link")).click();
        WebElement expected = driver.findElement(By.xpath("//div[@class = 'login_logo']"));
        Assert.assertTrue(expected.isDisplayed());
    }
}
