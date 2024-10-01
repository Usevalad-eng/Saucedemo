package pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BasePage {
    WebDriver driver;
    public static final String URL = "https://www.saucedemo.com/";

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
