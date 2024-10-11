package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InventoryPage extends BasePage {
    public static final By PRODUCT_LABEL = By.xpath("//span[text()='Products']");
    public String itemLocator = "//div[text()='%s']/ancestor::div[@class = 'inventory_item_description']//button[text() = 'Add to cart']";
    public static final By ITEM_ONE_ADD_TO_CART_BUTTON = By.id("add-to-cart-sauce-labs-backpack");
    public static final By BASKET_BUTTON = By.xpath("//a[@data-test='shopping-cart-link']");

    public static final By ADD_TO_CART_BUTTONS = By.xpath("//div[@class = 'inventory_item_description']//button");
    public static final By ADD_TO_CART_BUTTON = By.xpath("//button[text() = 'Add to cart']");

    public static final By REMOVE_BUTTON = By.xpath("//button[text() = 'Remove']");
    public static final By ITEM_NAME = By.xpath("//div[@data-test = 'inventory-item-name']");
    public static final By ITEM_PRICE = By.xpath("//div[@data-test = 'inventory-item-price']");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean inventoryPageIsOpen() {
        return driver.findElement(PRODUCT_LABEL).isDisplayed();
    }

    public void clickAddToCartButton() {
        driver.findElement(ITEM_ONE_ADD_TO_CART_BUTTON).click();
    }

    public void getItemAndClickAddToCartButton(String item) {
        driver.findElement(By.xpath(String.format(itemLocator, item))).click();  //"Sauce Labs Backpack"
    }

    public void clickBasketButton() {
        driver.findElement(BASKET_BUTTON).click();
    }

    public void logoutClick(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("logout_sidebar_link")));
    }

    public String getFirstItemName(){
        setWait();
        return driver.findElements(ITEM_NAME).get(0).getText();
    }

    public Double getFirstItemPrice(){
        setWait();
        String stringPrice = driver.findElements(ITEM_PRICE).get(0).getText().substring(1);
        return Double.parseDouble(stringPrice);
    }

    public void clickAddToCartFirstItem() {
        driver.findElements(ADD_TO_CART_BUTTON).get(0).click();
    }

    public void clickRemoveFirstItem() {
        driver.findElements(REMOVE_BUTTON).get(0).click();
    }
}
