package initialTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FindElementsTest extends BaseTest {

    @Test
    public void firstTest() {  //Task1
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name"));
        driver.findElement(By.xpath("//input[@id='user-name']"));
        driver.findElement(By.cssSelector("[id='user-name']"));
        driver.findElement(By.name("user-name"));
        driver.findElement(By.className("login_logo"));
        driver.findElement(By.tagName("input"));
        driver.findElement(By.xpath("//input[@id='user-name']"));
        driver.findElement(By.cssSelector("[class='submit-button btn_action']"));
        driver.findElement(By.xpath("//div[text()='Swag Labs']"));
        driver.findElement(By.xpath("//div[contains(text(),'Swag Labs')]"));
        driver.findElement(By.xpath("//input[contains(@id,'user')]"));
        driver.findElement(By.xpath("//input[@id='login-button' and @type='submit']"));
        driver.findElement(By.xpath("//input[@id='login-button'] | //input[@type='submit']"));
        driver.findElement(By.xpath("//div[@class='login_logo']//ancestor::div"));
        driver.findElement(By.xpath("//div[@class='login_logo']//parent::div"));
        driver.findElement(By.xpath("//div[@class='login_logo']//preceding::*"));
        driver.findElement(By.xpath("//div[@class='login_container']//descendant::div"));
        driver.findElement(By.xpath("//div[@class='login_container']//following::*"));
        driver.findElement(By.cssSelector("[class='login_credentials']"));
        driver.findElement(By.cssSelector(".login_credentials"));
        driver.findElement(By.cssSelector(".login_container .login_wrapper"));
        driver.findElement(By.cssSelector("#user-name"));
        driver.findElement(By.cssSelector("input"));
        driver.findElement(By.cssSelector("div.login_logo"));
        driver.findElement(By.cssSelector("[id='user-name']"));
        driver.findElement(By.cssSelector("[id~='user-name']"));
        driver.findElement(By.cssSelector("[id|='user']"));
        driver.findElement(By.cssSelector("[id^='user']"));
        driver.findElement(By.cssSelector("[id$='name']"));
        driver.findElement(By.cssSelector("[id*='name']"));
    }
}
