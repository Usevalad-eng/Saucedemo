package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public static final By FIRST_ITEM = By.cssSelector("[data-test='inventory-item-name']");

    public static final By FIRST_ITEM_PRICE = By.cssSelector("[data-test='inventory-item-price']");

    public String getFirstItem() {
        return driver.findElement(FIRST_ITEM).getText();
    }

    public String getFirstItemPrice() {
        return driver.findElement(FIRST_ITEM_PRICE).getText();
    }
}
