package initialTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import java.time.Duration;

import static pages.AuthPage.*;

public class LogoutTest extends BaseTest {
    @Test
    public void logoutTest() {
        driver.get(URL);
        driver.findElement(USERNAME).sendKeys("standard_user");
        driver.findElement(PASSWORD).sendKeys("secret_sauce");
        driver.findElement(LOGIN_BUTTON).click();
        driver.findElement(By.id("react-burger-menu-btn")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("logout_sidebar_link")));
        driver.findElement(By.id("logout_sidebar_link")).click();
        WebElement expected = driver.findElement(By.xpath("//div[@class = 'login_logo']"));
        Assert.assertTrue(expected.isDisplayed());
    }
}
