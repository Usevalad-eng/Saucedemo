package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    public static final String URL = "https://www.saucedemo.com/";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
    }

    public void setWait(){
        new ExpectedCondition<Boolean>(){
            public Boolean apply(WebDriver driver){
                return ((JavascriptExecutor)driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };
    }
    protected boolean isPageExist(By element) {
        return driver.findElement(element).isDisplayed();
    }

    protected boolean isPageOpened(By element) {
        return isPageExist(element);
    }

    protected boolean isPageExistV2(By element) {
        try {
            return driver.findElement(element).isDisplayed();
        }catch (NoSuchElementException exception){
            System.out.println("No such element");
            return false;
        }
    }
}

