import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BasePO {

    WebDriver driver;

    public BasePO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "li.product-item div.product-item-info a.product")
    List<WebElement> itemsList;

    @FindBy(xpath = "//ul[@id='ui-id-2']/li[2]")
    WebElement womenCategory;

    @FindBy(xpath = "//ul[@id='ui-id-2']/li[2]/ul/li[1]")
    WebElement womenTopsCategory;

    @FindBy(xpath = "//ul[@id='ui-id-2']/li[2]/ul/li[1]/ul/li[1]")
    WebElement womenJacketsCategory;

    @FindBy(css = "header.page-header div div[data-block='minicart']")
    WebElement cart;

    @FindBy(css = "header.page-header div div[data-block='minicart'] a span.counter.qty")
    WebElement cartCounter;

    @FindBy(css = "div.actions a.viewcart")
    WebElement viewAndEditCart;


    public ShoppingCartPagePO goToViewAndEditCart() {
        viewAndEditCart.click();
        ShoppingCartPagePO shoppingCartPagePO = new ShoppingCartPagePO(driver);
        return shoppingCartPagePO;
    }

    public void goToCart() {
        waitForCartToBeLoaded();
        cart.click();
    }

    public void waitForCartToBeLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(cartCounter, "class", "counter qty"));
    }

    public void goToCategory() {
        waitUntilElementIsVisible(womenCategory);
        Actions actions = new Actions(driver);
        actions.moveToElement(womenCategory).moveToElement(womenTopsCategory).moveToElement(womenJacketsCategory).build().perform();
        womenJacketsCategory.click();
    }


    public ItemPagePO openRandomItem() {
        Random random = new Random();
        int randomValue = random.nextInt(itemsList.size());
        itemsList.get(randomValue).click();
        ItemPagePO itemPagePO = new ItemPagePO(driver);
        return itemPagePO;
    }

    public void waitUntilElementIsVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
