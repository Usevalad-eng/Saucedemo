package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage{
    public static final By PRODUCT_LABEL = By.xpath("//span[text()='Products']");

 // //div[text()='Sauce Labs Backpack']//ancestor::div[@data-test='inventory-item-description']//descendant::button[@data-test='add-to-cart-sauce-labs-backpack']
    public String itemLocator = "//div[text()='%s']//ancestor::div[@data-test='inventory-item-description']//descendant::button[@data-test='add-to-cart-sauce-labs-backpack']";
    public static final By ITEM_ONE_ADD_TO_CART_BUTTON = By.id("add-to-cart-sauce-labs-backpack");
    public static final By BASKET_BUTTON = By.xpath("//a[@data-test='shopping-cart-link']");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    /*public void open(){
       driver.get(URL + "inventory.html");
    }*/
    public boolean inventoryPageIsOpen(){
        return driver.findElement(PRODUCT_LABEL).isDisplayed();
    }

    public void clickAddToCartButton(){
        driver.findElement(ITEM_ONE_ADD_TO_CART_BUTTON).click();
    }

    public void getItemAndClickAddToCartButton(String item){
        driver.findElement(By.xpath(String.format(item, itemLocator))).click();
    }

    public void clickBasketButton(){
        driver.findElement(BASKET_BUTTON).click();
    }
}
