package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageComponents.BasePage;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class ItemPage extends BasePage {

    public ItemPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    Random random = new Random();

    @FindBy(css = "h1.page-title")
    private WebElement itemTitle;

    @FindBy(css = "div.product-info-main div.product-info-price span.price")
    private WebElement itemPrice;

    @FindBy(css = "div.swatch-option.swatch-option.text")
    private List<WebElement> sizesList;

    @FindBy(css = "div.swatch-option.swatch-option.color")
    private List<WebElement> colorsList;

    @FindBy(css = "button[title='Add to Cart']")
    private WebElement addToCartButton;

    @FindBy(css = "div.actions a.viewcart")
    private WebElement viewAndEditCart;

    @FindBy(css = "header.page-header div div[data-block='minicart']")
    private WebElement cart;

    public ItemPage addToCartButtonClick() {
        addToCartButton.click();
        return this;
    }

    public ShoppingCartPage goToViewAndEditCart() {
        viewAndEditCart.click();
        ShoppingCartPage shoppingCartPagePO = new ShoppingCartPage(driver);
        return shoppingCartPagePO;
    }

    public ItemPage goToCart() {
        waitForCartToBeLoaded();
        cart.click();
        return this;
    }

    public ItemPage selectRandomColor() {
        waitUntilListOfElementsIsVisible(colorsList);
        int randomValue = random.nextInt(colorsList.size());
        colorsList.get(randomValue).click();
        return this;
    }

    public ItemPage selectRandomSize() {
        int randomValue = random.nextInt(sizesList.size());
        sizesList.get(randomValue).click();
        return this;
    }

    public String getSelectedColor() {
        String selectedColor = null;
        for (int i = 0; i < colorsList.size(); i++) {
            String attributeValue = colorsList.get(i).getAttribute("aria-checked");
            if (attributeValue.equalsIgnoreCase("true")) {
                selectedColor = colorsList.get(i).getAttribute("aria-label");
            }
        }
        return selectedColor;
    }

    public String getSelectedSize() {
        String selectedSize = null;
        for (int i = 0; i < sizesList.size(); i++) {
            String attributeValue = sizesList.get(i).getAttribute("aria-checked");
            if (attributeValue.equalsIgnoreCase("true")) {
                selectedSize = sizesList.get(i).getText();
            }
        }
        return selectedSize;
    }

    public String getItemPrice() {
         String itemPriceText = itemPrice.getText();
         return itemPriceText;
    }

    public String getItemTitle() {
        String itemTitleText = itemTitle.getText();
        return itemTitleText;
    }
}



