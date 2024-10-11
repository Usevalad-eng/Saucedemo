package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage {
    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void setWait() {
        super.setWait();
    }

    @Override
    protected boolean isPageExist(By element) {
        return super.isPageExist(element);
    }

    @Override
    protected boolean isPageOpened(By element) {
        return super.isPageOpened(element);
    }
}
