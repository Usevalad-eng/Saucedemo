package tests.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;
import tests.base.TestListener;

import java.time.Duration;

@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected AuthPage authPage;
    protected InventoryPage inventoryPage;
    protected CartPage cartPage;
    protected CheckoutStepOnePage checkoutStepOnePage;
    protected CheckoutStepTwoPage checkoutStepTwoPage;

    protected CheckoutCompletePage checkoutCompletePage;

    @Parameters({"browser"})
    @BeforeMethod(description = "settings")
    public void setUp(@Optional("chrome") String browser, ITestContext context) {
        if (browser.equals("chrome")){
            driver = new ChromeDriver();
        }else {
            driver = new EdgeDriver();
        }
        //driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        context.setAttribute("driver", driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        authPage = new AuthPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutStepOnePage = new CheckoutStepOnePage(driver);
        checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
    }

    @AfterMethod(alwaysRun = true, description = "close page")
    public void tearDown() {
        //driver.manage().deleteAllCookies();
        driver.quit();
    }
}

