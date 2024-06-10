package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageComponents.BasePage;

public class ShoppingCartPage extends BasePage {

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//table[@id='shopping-cart-table']/tbody/tr[1]/td[1]/div/dl/dd[1]")
    private WebElement itemSize;

    @FindBy(xpath = "//table[@id='shopping-cart-table']/tbody/tr[1]/td[1]/div/dl/dd[2]")
    private WebElement itemColor;

    @FindBy(xpath = "//table[@id='shopping-cart-table']/tbody/tr[1]/td[1]/div/strong/a")
    private WebElement itemTitle;

    @FindBy(xpath = "//table[@id='shopping-cart-table']/tbody/tr[1]/td[2]//span[@class='price']")
    private WebElement itemPrice;

    @FindBy(xpath = "//table[@id='shopping-cart-table']/tbody/tr[1]/td[4]//span[@class='price']")
    private WebElement subtotalPrice;

    @FindBy(css = "input[title='Qty']")
    private WebElement qty;

    @FindBy(css = "button[value='update_qty']")
    private WebElement updateShoppingCartButton;

    @FindBy(css = "div.loading-mask")
    private WebElement loader;

    public int getSubtotalPrice() {
        waitUntilElementDisappear(loader);
        String subPrice = subtotalPrice.getText();
        String finalSubPrice = subPrice.substring(1, subPrice.length() - 3);
        int intSubPrice = Integer.parseInt(finalSubPrice);
        return intSubPrice;
    }

    public int getItemPriceInt() {
        String price = itemPrice.getText();
        String finalItemPrice = price.substring(1, price.length() - 3);
        int priceInt = Integer.parseInt(finalItemPrice);
        return priceInt;
    }

    public ShoppingCartPage updateShoppingCart() {
        updateShoppingCartButton.click();
        return this;
    }

    public ShoppingCartPage setQty(int qtyValue) {
        qty.clear();
        qty.sendKeys(String.valueOf(qtyValue));
        return this;
    }

    public String getItemPrice() {
        String price = itemPrice.getText();
        return price;
    }

    public String getItemTitle() {
        return itemTitle.getText();
    }

    public String getItemSize() {
        return itemSize.getText();
    }

    public String getItemColor() {
        return itemColor.getText();
    }
}
