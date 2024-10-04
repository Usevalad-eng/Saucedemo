package initialTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AuthPage;
import tests.BaseTestSaucedemo;

import java.time.Duration;

import static pages.AuthPage.*;
import static pages.InventoryPage.PRODUCT_LABEL;

public class Logout extends BaseTestSaucedemo {

    @Test
    public void logoutTest() {
        driver.get(URL);
        driver.findElement(USERNAME).sendKeys("standard_user");
        driver.findElement(PASSWORD).sendKeys("secret_sauce");
        driver.findElement(LOGIN_BUTTON).click();
        driver.findElement(By.id("react-burger-menu-btn")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.id("logout_sidebar_link")).click();
        WebElement expected = driver.findElement(By.xpath("//div[@class = 'login_logo']"));
        Assert.assertTrue(expected.isDisplayed());
    }
}
