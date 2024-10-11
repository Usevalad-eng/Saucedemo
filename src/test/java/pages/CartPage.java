package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public static final By FIRST_ITEM = By.cssSelector("[data-test='inventory-item-name']");
    public static final By FIRST_ITEM_PRICE = By.cssSelector("[data-test='inventory-item-price']");
    public static final By CART_LABEL = By.xpath("//span[text()='Your Cart']");

    List<WebElement> removeButtons = driver.findElements(By.xpath("//button[text() = 'Remove']"));
    public String getFirstItem() {
        return driver.findElement(FIRST_ITEM).getText();
    }
    public String getFirstItemPrice() {
        return driver.findElement(FIRST_ITEM_PRICE).getText();
    }

    @Override
    protected boolean isPageOpened(By element) {
        return isPageExist(CART_LABEL);
    }

    public void removeAllItems(){
        for (WebElement removeButton : removeButtons){
            removeButton.click();
            setWait();
        }
    }

    public List<WebElement> getRemovedButtons(){
        return driver.findElements(By.xpath("//button[text() = 'Remove']"));
    }

    public void removeAllItems_(){
        for (WebElement removeButton : getRemovedButtons()){
            removeButton.click();
            System.out.println("removed");
        }
    }
}
