import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class ItemPagePO extends BasePO {


    public ItemPagePO(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "h1.page-title")
    WebElement itemTitle;

    @FindBy(css = "div.product-info-main div.product-info-price span.price")
    WebElement itemPrice;

    @FindBy(css = "div.swatch-option.swatch-option.text")
    List<WebElement> sizesList;

    @FindBy(css = "div.swatch-option.swatch-option.color")
    List<WebElement> colorsList;

    @FindBy(css = "button[title='Add to Cart']")
    WebElement addToCartButton;


    public void addToCartButtonClick() {
        addToCartButton.click();
    }


    public void selectRandomColor() {
        waitForColorsToBeVisible();
        Random random = new Random();
        int randomValue = random.nextInt(colorsList.size());
        colorsList.get(randomValue).click();
    }


    public void selectRandomSize() {
        Random random = new Random();
        int randomValue = random.nextInt(sizesList.size());
        sizesList.get(randomValue).click();
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

    public void waitForColorsToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(colorsList));
    }
}



